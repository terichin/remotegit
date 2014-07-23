package univelec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univelec.action.*;
import univelec.dao.DAOException;
import univelec.dto.UserDTO;

/**
 * Servlet implementation class Control
 */
@WebServlet("/control")
/*
 * Model�EJSP�̎��s���������N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class Control extends HttpServlet {

	/* 
	 * �@�@�\�F�@���[�U�����Ƀ��O�C�����Ă��邩���m�F���邽�߂̃��\�b�h�B
	 *           �Z�b�V�����I�u�W�F�N�g�ƃZ�b�V��������UserDTO�������
	 *           ���O�C�����Ă���ƌ��Ȃ��B
	 * 
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@�������Z�b�V��������������Ă����true�A�����łȂ����false��Ԃ��B
	 * ���@���F�@�܂��Z�b�V�����I�u�W�F�N�g�̗L�����`�F�b�N���A�Z�b�V�����������
	 *           �Z�b�V�������� UserDTO �̎擾�����݂�B����̎擾���ł����
	 *           ���������O�C������Ă���Ɣ��f����B
	 */
	private boolean checkSession(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null) {
			return false;
		}

		// UserDTO���擾�ł��Ȃ�(null)���ɂ̓��O�C�����Ă���Ƃ͌��Ȃ��Ȃ��B
		UserDTO user = (UserDTO) session.getAttribute("login_dto");
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
	 *           �ԋp����B�s���ȃA�N�V�������̓f�t�H���g�̃A�N�V������
	 *           �������ĕԋp����B
	 */
	private Action createAction(String name) {
		if ("p001-login".equals(name)) {
			// ���O�C���A�N�V������ԋp����B
			return new LoginAction();
		} else if ("p002-itemSearch".equals(name)) {
			// ���i�ꗗ�����A�N�V������ԋp����B
			return new ItemListSearchAction();
		} else if ("p002-orderHistory".equals(name)) {
			// ��������\���A�N�V������ԋp����B
			return new OrderSearchAction();
		} else if ("p002-orderSearch".equals(name)) {
			// �����������[�U�R�[�h���̓A�N�V������ԋp����B
			return new OrderSearchConditionAction();
		} else if ("p002-userList".equals(name)) {
			// ���[�U���ꗗ�\���A�N�V������ԋp����B
			return new UserSearchAction();
		} else if ("p002-userAdd".equals(name)) {
			// ���[�U�����̓A�N�V������ԋp����B
			return new UserAddInputAction();
		} else if ("p002-syukei".equals(name)) {
			// TODO: �W�v�A�N�V������ԋp����B
		} else if ("p002-logout".equals(name)) {
			// ���O�A�E�g�A�N�V������ԋp����B
			return new LogoutAction();
		} else if ("p101-select".equals(name)) {
			// ���i�I���A�N�V������ԋp����B
			return new ItemSearchAction();
		} else if ("p102-order".equals(name)) {
			// ���i�����A�N�V������ԋp����B
			return new ItemOrderAction();
		} else if ("p201-select".equals(name)) {
			// ��������\���A�N�V������ԋp����B
			return new OrderSearchOneAction();
		} else if ("p202-cancel".equals(name)) {
			// �����L�����Z���A�N�V������ԋp����B
			return new OrderCancelAction();
        } else if ("p211-search".equals(name)) {
        	// ���[�U�̒�������\���A�N�V������ԋp����B
            return new OrderSearchUserAction();
		} else if ("p301-select".equals(name)) {
			// ���[�U���I���A�N�V������ԋp����B
			return new UserEditSearchAction();
		} else if ("p302-edit".equals(name)) {
			// ���[�U���ҏW�A�N�V������ԋp����B
			return new UserEditAction();
		} else if ("p302-delete".equals(name)) {
			// ���[�U���폜�A�N�V������ԋp����B
			return new UserDeleteAction();
		} else if ("p401-add".equals(name)) {
			// ���[�U���ǉ��A�N�V������ԋp����B
			return new UserAddAction();
		}

		//���j���[�\���A�N�V������ԋp����B
		return new MenuAction();
	}

	/* 
	 * �@�@�\�F�@�ŏ��̃��N�G�X�g���Ƀ��O�C����ʂ�\�����郁�\�b�h�B
	 * 
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 *           �I�[�o�[���C�h�ł��邽�߁AHttpServletResponse���󂯎��B
	 * ���@���F�@�܂��Z�b�V�����I�u�W�F�N�g�̗L�����`�F�b�N���A�Z�b�V�����������
	 *           �����j������B���̌ネ�O�C����ʂɑJ�ڂ���B
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/page/login.jsp");
		rd.forward(req, res);
	}

	/* 
	 * �@�@�\�F�@2�x�ڈȍ~�̃��N�G�X�g���������郁�\�b�h�B
	 * 
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 *           �I�[�o�[���C�h�ł��邽�߁AHttpServletResponse���󂯎��B
	 * ���@���F�@���O�C���������ȊO��checkSession���\�b�h���Ăяo���A���[�U��
	 *           ���O�C���󋵂��m�F����B����Ƀ��O�C�����Ă���ꍇ�́A�{�^������
	 *           �擾���A�{�^�����ɑΉ�����Model�N���X�̃I�u�W�F�N�g�𐶐�����B
	 *           ���������I�u�W�F�N�g��check���\�b�h���Ăяo���ē��͒l�̌`����
	 *           �m�F����B���͒l�̌`���ɖ�肪�������execute���\�b�h���Ăяo����
	 *           ���������s����Bexecute���\�b�h�͎��ɑJ�ڂ��ׂ��p�X��Ԃ��Ă���
	 *           �̂Ŏw��̑J�ڐ�ɑJ�ڂ���B
	 *           ���͒l�̌`���̃G���[��execute���\�b�h���s���ɗ�O�����������ꍇ��
	 *           �Z�b�V������ؒf���A�G���[��ʂɑJ�ڂ���B
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
		RequestDispatcher rd = null;
		String actionName = req.getParameter("action");

		if (!("p001-login".equals(actionName)) && checkSession(req) == false) {
			// �Z�b�V�����������A�������� UserDTO ���������߁A
			// ���̑J�ڐ���G���[��ʂɂ���B
			rd = req.getRequestDispatcher("/page/loginerror.jsp");
		} else {
			// �{�^��������A���s����A�N�V�������擾����B
			Action action = createAction(actionName);

			if (action.check(req)) {
				// �p�����[�^�̃`�F�b�N��OK�̂��߁A�����𑱍s����B
				try {
					String path = action.execute(req);
					rd = req.getRequestDispatcher(path);
				} catch (DAOException e) {
					// ��O�������������߁A���̑J�ڐ���G���[��ʂɂ���B
                    e.printStackTrace();
					rd = req.getRequestDispatcher("/page/dberror.jsp");
				}
			} else {
				// �p�����[�^�̃`�F�b�N��NG�̂��߁A���̑J�ڐ��
				// �G���[��ʂɂ���B
				rd = req.getRequestDispatcher("/page/inputerror.jsp");
				HttpSession session = req.getSession(false);
				if (session != null) {
					session.invalidate();
				}
			}
		}

		// ���̉�ʂɑJ��
		rd.forward(req, res);
	}
}
