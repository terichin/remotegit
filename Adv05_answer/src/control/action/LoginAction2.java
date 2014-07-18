package control.action;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class LoginAction2 implements Action {
	private int empId;			// ���[�U�R�[�h
	private String password;	// �p�X���[�h
	
	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U�R�[�h�ƃp�X���[�h��null�܂��͋󕶎��łȂ���
	 *           �`�F�b�N����B
	 */
	public boolean check(HttpServletRequest req) {
		// ���[�U�R�[�h�̃`�F�b�N
		String paramId = req.getParameter("EMPID");
		if ((paramId == null) || ("".equals(paramId))) {
			return false;
		}
		try {
			empId = Integer.parseInt(paramId);
		} catch (NumberFormatException e) {
			return false;
		}
		// �p�X���[�h�̃`�F�b�N
		password = req.getParameter("PASSWORD");
		if ((password == null) || ("".equals(password))) {
			return false;
		}
		return true;
	}
	
	/*
	 * �@�@�\�F�@���O�C�����������s���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@���O�C���������ɂ̓��j���[��ʂ̃p�X��Ԃ��B
	 *           ���O�C�����s���ɂ̓G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U�R�[�h�ƃp�X���[�h���g�p���āA���͂��ꂽ���
	 *           DBMS�ɓo�^����Ă��邱�Ƃ��m�F����B���DBMS�ɓo�^����Ă����
	 *           ���������[�U�Ƃ݂Ȃ��ăZ�b�V�����𐶐����A���͂��ꂽ���[�U����
	 *           �Z�b�V�����ɕۑ����ă��j���[��ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		EmployeeDTO emp = new EmployeeDTO(empId, "", password);
		NewEmployeeDAO dao = new NewEmployeeDAO();
		if (dao.checkLogin(emp) == true) {
			// ���O�C���ɐ��������̂ŃZ�b�V�����𐶐����A���[�U����o�^���܂�
			HttpSession session = req.getSession(true);
			session.setAttribute("login_dto", emp);

			return "/html/menu2.html";
		} else {
			// ���[�U�F�؂Ɏ��s�����̂ŃG���[��ʂ�
			return "/html/loginerror.html";
		}
	}
}
