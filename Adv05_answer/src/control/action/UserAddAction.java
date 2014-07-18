package control.action;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class UserAddAction implements Action {
    private String name;     // ���O
    private String password; // �p�X���[�h

    /*
     * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
     *
     * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
     * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
     * ���@���F�@���͂��ꂽ���[�U���̊e���e���`�F�b�N����B
     */
    public boolean check(HttpServletRequest req) {
        // �����̃`�F�b�N
        name = req.getParameter("name");
        if ((name == null) || (name.equals("") == true)) {
            return false;
        }
        // �p�X���[�h�̃`�F�b�N
        password = req.getParameter("password");
        if ((password == null) || (password.equals("") == true)) {
            return false;
        }
        return true;
    }

    /*
     * �@�@�\�F�@���[�U���̓o�^�����s���郁�\�b�h�B
     *
     * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
     * �߂�l�F�@���[�U���̓o�^�ɐ��������ꍇ�́A���[�U���ǉ�������ʂ̃p�X��Ԃ��B
     *�@�@�@�@�@�@���[�U���̓o�^�Ɏ��s�����ꍇ�́A�G���[��ʂ̃p�X��Ԃ��B
     * ���@���F�@���͂��ꂽ�p�����[�^�������o�ϐ�����擾����DTO�𐶐����AEmployeeDAO��
     *�@�@�@�@�@�@���\�b�h�ɍ쐬����DTO��n���ă��[�U����o�^����B�o�^�������[�U����
     *�@�@�@�@�@�@����ʂ̕\���ŕK�v�ƂȂ邽�߃Z�b�V�����ɕۑ����A���[�U���ǉ�������ʂ�
     *�@�@�@�@�@�@�J�ڂ���B
     */
    public String execute(HttpServletRequest req) throws DAOException {
        // ���[�U�R�[�h�͌�ō̔Ԃ��邽�߁A��芸����-1����ꂽ
        // ���͏�������EmployeeDTO���쐬����
        EmployeeDTO dto = new EmployeeDTO(-1, name, password);
        NewEmployeeDAO dao = new NewEmployeeDAO();
        int result = dao.addUser(dto);
        if (result != 1) {
            // ���[�U���ǉ��Ɏ��s�����̂ŁA�G���[��ʂɑJ��
            return "/html/systemerror.html";
        }
        HttpSession session = req.getSession(false);
        // ����JSP�ŕ\�����邽�߁ADB�ɓn����DTO���Z�b�V�����Ɋi�[����
        // �̔Ԃ��ꂽ�V���ȃ��[�U�R�[�h��DAO�ɂ���ď����������Ă���
        session.setAttribute("emp_dto", dto);

        return "/page/userAddComplete.jsp";
    }
}
