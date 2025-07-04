using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assignment
{
    public partial class Admin_Tutor_AddSubject : Form
    {
        public static string username;
        public static string name;
        public Admin_Tutor_AddSubject(string un,string na)
        {
            InitializeComponent();
            username = un;
            name = na;
        }

        private void add_button_enable()
        {
            if (cb_admtutorlevel.SelectedItem != null && cb_admtutorsub.SelectedItem != null)
            {
                btn_admtutoraddlvsub.Enabled = true;
            }
            else
            {
                btn_admtutoraddlvsub.Enabled = false;
            }
        }

        private void btn_admtutorcancellvsub_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void cb_admtutorlevel_SelectedIndexChanged(object sender, EventArgs e)
        {
            add_button_enable();
        }

        private void cb_admtutorsub_SelectedIndexChanged(object sender, EventArgs e)
        {
            add_button_enable();
        }

        private void btn_admtutoraddlvsub_Click(object sender, EventArgs e)
        {
            string level = cb_admtutorlevel.SelectedItem.ToString().Substring(5);
            Int32 lv = Int32.Parse(level);
            MessageBox.Show(AdminClass.add_subject(username,name,lv, cb_admtutorsub.SelectedItem.ToString()));
            AdminClass.update_income_subject(username);
        }
    }
}
