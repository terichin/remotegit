package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.action.*;
import control.dao.DAOException;
import control.dto.EmployeeDTO;

/**
 * Servlet implementation class Control
 */
@WebServlet("/control")
public class Control extends HttpServlet {
    /* 
     * �@�@�\�F�@�ŏ��̃��N�G�X�g���Ƀ��O�C����ʂ�\�����郁�\�b�h�B
     * 
     * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
     *�@�@�@�@�@�@�I�[�o�[���C�h�ł��邽�߁AHttpServletResponse���󂯎��B
     * ���@���F�@�܂��Z�b�V�����I�u�W�F�N�g�̗L�����`�F�b�N���A�Z�b�V�����������
     *�@�@�@�@�@�@�����j������B���̌ネ�O�C����ʂɑJ�ڂ���B
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/html/login.html");
        rd.forward(req, res);
    }
    
    /* 
     * �@�@�\�F�@2�x�ڈȍ~�̃��N�G�X�g���������郁�\�b�h�B
     * 
     * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
     *�@�@�@�@�@�@�I�[�o�[���C�h�ł��邽�߁AHttpServletResponse���󂯎��B
     * ���@���F�@���N�G�X�g�����m�F���A���O�C����ʂ���̗v���������ꍇ�́A
     *�@�@�@�@�@�@LoginAction�I�u�W�F�N�g�𐶐����Acheck()���\�b�h��execute()
     *�@�@�@�@�@�@���\�b�h���Ăяo���B���炩�̏��������s�����ꍇ�̓G���[��ʂ�
     *�@�@�@�@�@�@�J�ڂ���B
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        RequestDispatcher rd = null;
        String actionName = req.getParameter("action");

        // ��ʎ���ID�ɉ������A�N�V���������s����
        if (!(actionName.equals("login")) && checkSession(req) == false) {
            // ���O�C����ʂł͂Ȃ��A���̃V�X�e���̃��O�C�������𖞂����Ă��Ȃ�����
            // ���̑J�ڐ���G���[��ʂɂ���B
            rd = req.getRequestDispatcher("/html/systemerror.html");
        } else {
            Action action = createAction(actionName);
            if (action != null) {
                try {
                    if (action.check(req)) {
                        // ���͒l�̃`�F�b�N��OK�̂��߁A�����̎��s���s���B
                        String path = action.execute(req);
                        rd = req.getRequestDispatcher(path);
                    } else {
                        rd = req.getRequestDispatcher("/html/checkerror.html");
                    }
                } catch (DAOException e) {
                    e.printStackTrace();
                    rd = req.getRequestDispatcher("/html/dberror.html");
                }
            } else {
                // �_���I�ɂ��蓾�Ȃ����A�ی��Ƃ��Ēǉ�����
                rd = req.getRequestDispatcher("/html/systemerror.html");
            }
        }
        rd.forward(req, res);
    }
    
    /* 
     * �@�@�\�F�@���[�U�����Ƀ��O�C�����Ă��邩���m�F���邽�߂̃��\�b�h�B
     *�@�@�@�@�@�@�Z�b�V�����I�u�W�F�N�g�ƃZ�b�V��������UserDTO�������
     *�@�@�@�@�@�@���O�C�����Ă���ƌ��Ȃ��B
     * 
     * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
     * �߂�l�F�@�������Z�b�V��������������Ă����true�A�����łȂ����false��Ԃ��B
     * ���@���F�@�܂��Z�b�V�����I�u�W�F�N�g�̗L�����`�F�b�N���A�Z�b�V�����������
     *�@�@�@�@�@�@�Z�b�V�������� EmployeeDTO �̎擾�����݂�B����̎擾���ł����
     *�@�@�@�@�@�@���������O�C������Ă���Ɣ��f����B
     */
    private boolean checkSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }

        // EmployeeDTO���擾�ł��Ȃ����ɂ̓��O�C�����Ă���Ƃ͌��Ȃ��Ȃ��B
        EmployeeDTO user = (EmployeeDTO) session.getAttribute("login_dto");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * �@�@�\�F�@�A�N�V�����𐶐�����B
     *
     * ���@���F�@�A�N�V�������B
     * �߂�l�F�@�A�N�V�����B
     * ���@���F�@�����̃A�N�V�������Ɋ�Â��A�R�t���A�N�V�����𐶐�����
     *�@�@�@�@�@�@�ԋp����B�s���ȃA�N�V�������̓f�t�H���g�̃A�N�V������
     *�@�@�@�@�@�@�������ĕԋp����B
     */
    private Action createAction(String name) {
        if ("login".equals(name)) {
            // ���O�C���A�N�V������ԋp���܂�
            return new LoginAction();
        } else if ("search".equals(name)) {
            // ���[�U�o�^��ʕ\���A�N�V������ԋp���܂�
            return new UserSearchScreenAction();
        } else if ("searchone".equals(name)) {
            // ���[�U�o�^��ʕ\���A�N�V������ԋp���܂�
            return new UserSearchAction();
        } else if ("add".equals(name)) {
            // ���[�U�o�^��ʕ\���A�N�V������ԋp���܂�
            return new UserAddScreenAction();
        } else if ("regist".equals(name)) {
            // ���[�U�o�^�A�N�V������ԋp���܂�
            return new UserAddAction();
        } else if ("update".equals(name)) {
            // ���[�U�X�V������ʃA�N�V������ԋp���܂�
            return new UserUpdateScreenAction();
        } else if ("updatesearch".equals(name)) {
            // ���[�U�X�V�����A�N�V������ԋp���܂�
            return new UserUpdateSearchAction();
        } else if ("renew".equals(name)) {
            // ���[�U�X�V�A�N�V������ԋp���܂�
            return new UserUpdateAction();
        } else if ("expenseadd".equals(name)) {
        	// �o��o�^��ʕ\���A�N�V������ԋp���܂�
        	return new ExpenseAddScreenAction();
        } else if ("expenseregist".equals(name)) {
     	    // �o��o�^�A�N�V������ԋp���܂�
     	    return new ExpenseAddAction();
     	} else if ("searchall".equals(name)) {
            // ���[�U�S�������A�N�V������ԋp���܂�
            return new AllUserSearchAction();
        } else if ("searchallcontact".equals(name)) {
            // �d�b�ԍ��S�������A�N�V������ԋp���܂�
            return new AllContactSearchAction(); 
        } else if ("searchexpense".equals(name)) {
            // �o�����ʕ\���A�N�V������ԋp���܂�
            return new ExpenseSearchScreenAction();
        } else if ("searchexpense2".equals(name)) {
            // �o�����ʕ\���A�N�V������ԋp���܂�
            return new ExpenseSearchScreenAction2();
        } else if ("searchexpenseuser".equals(name)) {
            // �o����A�N�V������ԋp���܂�
            return new ExpenseSearchAction(); 
        } else if ("searchexpenseuser2".equals(name)) {
            // �o����A�N�V������ԋp���܂�
            return new ExpenseSearchAction2(); 
        } else if ("searchemployee".equals(name)) {
            // ���[�U��񌟍���ʕ\���A�N�V������ԋp���܂�
            return new EmployeeInfoSearchScreenAction();
        } else if ("searchemployeeid".equals(name)) {
            // ���[�U��񌟍��A�N�V������ԋp���܂�
            return new EmployeeInfoSearchAction();
        } else if ("logout".equals(name)) {
            // ���O�A�E�g�A�N�V������ԋp���܂�
            return new LogoutAction();
        }
        //�i�ǂ̏����ɂ���v���Ȃ������ꍇ�́j���j���[�A�N�V������ԋp���܂�
        return new MenuAction();
    }
}