using System;
using System.Collections;
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
    public partial class Admin_Tutor_Subject : Form
    {
        public static string username;
        public static string name;
        public Admin_Tutor_Subject(string un,string na)
        {
            InitializeComponent();
            username = un;
            name = na;
        }

        private void update_listbox()
        {
            //this fuction is to update the list box
            lb_admtutorlvsub.Items.Clear();
            ArrayList subject = new ArrayList();
            subject = AdminClass.view_tutor_subject(username);
            foreach (var sub in subject)
            {
                lb_admtutorlvsub.Items.Add(sub);
            }
        }
        private void btn_admtutoraddsub_Click(object sender, EventArgs e)
        {
            Admin_Tutor_AddSubject obj1 = new Admin_Tutor_AddSubject(username,name);
            obj1.ShowDialog();
            update_listbox();
        }

        private void lb_admtutorlvsub_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lb_admtutorlvsub.SelectedIndex != -1)
            {
                btn_admtutordelsub.Enabled = true;
            }
            else
            {
                btn_admtutordelsub.Enabled = false;
            }
        }

        private void btn_admtutorsubback_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Admin_Tutor_Subject_Load(object sender, EventArgs e)
        {
            label2.Text = name;
            try
            {
                update_listbox();
            }
            catch
            {
                lb_admtutorlvsub.Items.Clear();
            }
        }

        private void btn_admtutordelsub_Click(object sender, EventArgs e)
        {
            string[] words = lb_admtutorlvsub.SelectedItem.ToString().Split("     ");
            string level = words[0].Substring(5);
            MessageBox.Show(AdminClass.delete_subject(username, level, words[1]));
            AdminClass.update_income_subject(username);
            update_listbox();
            btn_admtutordelsub.Enabled = false;
        }
    }
}
