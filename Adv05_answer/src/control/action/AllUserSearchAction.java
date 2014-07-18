package control.action;
import java.util.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class AllUserSearchAction implements Action {
    /*
     * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
     *
     * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
     * �߂�l�F�@���true��Ԃ��B
     * ���@���F�@�`�F�b�N����p�����[�^�͖������߁A���true��Ԃ��B
     */
    public boolean check(HttpServletRequest req) {
        // �`�F�b�N������̂������̂ŏ��true��Ԃ�
        return true;
    }

    /*
     * �@�@�\�F�@���[�U���̈ꗗ���擾���郁�\�b�h�B
     *
     * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
     * �߂�l�F�@���[�U���ꗗ��ʂ̃p�X��Ԃ��B
     * ���@���F�@DBMS����o�^����Ă��郆�[�U���ꗗ���擾����B�擾�����ꗗ��
     *�@�@�@�@�@�@����ʂŕK�v�ƂȂ邽�߃Z�b�V�����ɕۑ����A���[�U���ꗗ��ʂɑJ�ڂ���B
     */
    public String execute(HttpServletRequest req) throws DAOException {
        NewEmployeeDAO dao = new NewEmployeeDAO();
        // DAO���g���A�S���������ʂ��擾����
        // ���O�C�����Ă̑���Ȃ��߁A�������ʂ�0���͂��蓾�Ȃ�
        ArrayList<EmployeeDTO> list = dao.searchAllUser();
        HttpSession session = req.getSession(false);
        // �擾�����S���������ʂ��Z�b�V�����Ɋi�[���AJSP�ŕ\������
        session.setAttribute("emp_list", list);
        return "/page/userSearch.jsp";
    }
}

