using System.Collections;

namespace Assignment
{
    public partial class Admin : Form
    {
        public static string username;
        public Admin(string un)
        {
            InitializeComponent();
            username = un;
        }

        private void UpdateDetail()
        {
            //this function is to update the admin page after load this page
            ArrayList admin_detail = new ArrayList();
            AdminClass admin = new AdminClass(username);
            admin_detail = admin.view_admin_detail(username);
            lbl_admid.Text = username;
            lbl_admname.Text = admin_detail[0].ToString();
            lbl_admcountry.Text = admin_detail[1].ToString();
            if (admin_detail[1].ToString() == "Malaysia" && admin_detail[2].ToString().Length < 12)
            {
                lbl_admic.Text = "0" + admin_detail[2].ToString();
            }
            else
            {
                lbl_admic.Text = admin_detail[2].ToString();
            }
            lbl_admgender.Text = admin_detail[3].ToString();
            lbl_admemail.Text = admin_detail[4].ToString();
            lbl_admcontact.Text = admin_detail[5].ToString();
            lbl_admaddress.Text = admin_detail[6].ToString();
        }
        private void button5_Click(object sender, EventArgs e)
        {
            Update_Personal_Detail obj1 = new Update_Personal_Detail(username);
            obj1.ShowDialog();
            UpdateDetail();
        }

        private void btn_signout_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btn_tutor_Click(object sender, EventArgs e)
        {
            Admin_Tutor obj2 = new Admin_Tutor();
            obj2.ShowDialog();
        }

        private void btn_recep_Click(object sender, EventArgs e)
        {
            Admin_Receptionist obj3 = new Admin_Receptionist();
            obj3.ShowDialog();
        }

        private void btn_income_Click(object sender, EventArgs e)
        {
            Monthly_income obj4 = new Monthly_income();
            obj4.ShowDialog();
        }

        private void btn_changepass_Click(object sender, EventArgs e)
        {
            Change_Password obj5 = new Change_Password(username);
            obj5.ShowDialog();
        }

        private void Admin_Load(object sender, EventArgs e)
        {
            UpdateDetail();
        }
    }
}