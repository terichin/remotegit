package control.action;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class UserUpdateAction implements Action {
    private int empId;          // ���[�U�R�[�h
    private String name;        // ���O
    private String password;    // �p�X���[�h

    /*
     * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
     *
     * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
     * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
     * ���@���F�@���͂��ꂽ���[�U���̊e�ҏW���e���`�F�b�N����B
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
        // ���O�̃`�F�b�N
        name = req.getParameter("name");
        if ((name == null) || ("".equals(name) == true)) {
            return false;
        }
        // �p�X���[�h�̃`�F�b�N
        password = req.getParameter("password");
        if ((password == null) || ("".equals(password) == true)) {
            return false;
        }
        return true;
    }

    /*
     * �@�@�\�F�@���[�U���̍X�V�����s���郁�\�b�h�B
     *
     * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
     * �߂�l�F�@���[�U���X�V�ɐ��������ꍇ�́A���[�U���ҏW������ʂ̃p�X��Ԃ��B
     *           ���[�U���X�V�Ɏ��s�����ꍇ�́A�G���[��ʂ̃p�X��Ԃ��B
     * ���@���F�@���͂��ꂽ�p�����[�^���g�p����DTO�I�u�W�F�N�g�𐶐����A
     *           EmployeeDAO�̃��\�b�h��DTO��n���ă��[�U�����X�V����B
     *           �X�V�Ɏg�p�������͎���ʂŕK�v�ƂȂ邽�߃Z�b�V�����ɕۑ����A
     *           ���[�U���ҏW������ʂɑJ�ڂ���B
     */
    public String execute(HttpServletRequest req) throws DAOException {
        EmployeeDTO dto = new EmployeeDTO(empId, name, password);
        NewEmployeeDAO dao = new NewEmployeeDAO();
        int result = dao.updateUser(dto);
        if (result != 1) {
            return "/html/systemerror.html";
        }
        HttpSession session = req.getSession(false);
        session.setAttribute("emp_dto", dto);

        return "/page/userUpdateComplete.jsp";
    }
}