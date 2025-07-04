using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assignment
{
    public partial class Admin_Tutor : Form
    {
        public Admin_Tutor()
        {
            InitializeComponent();
        }

        private void add_item()
        {
            //this fuction is to adding the name of the tutor into the list box
            lb_admtutor.Items.Clear();
            ArrayList all_tutor = new ArrayList();
            all_tutor = AdminClass.view_all_name("tutor");

            foreach (var name in all_tutor)
            {
                lb_admtutor.Items.Add(name);
            }
        }

        private void btn_admretutor_Click(object sender, EventArgs e)
        {
            Admin_Register obj1 = new Admin_Register();
            obj1.ShowDialog();
            add_item();
        }

        private void btn_admsetutor_Click(object sender, EventArgs e)
        {
            string[] words = lb_admtutor.SelectedItem.ToString().Split("     ");
            string username = words[0];
            string name = words[1];
            Admin_Tutor_Subject obj2 = new Admin_Tutor_Subject(words[0],words[1]);
            obj2.ShowDialog();
        }
        private void lb_admtutor_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lb_admtutor.SelectedIndex != -1)
            {
                btn_admsetutor.Enabled = true;
                btn_admdetutor.Enabled = true;
            }
            else
            {
                btn_admsetutor.Enabled = false;
                btn_admdetutor.Enabled = false;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Admin_Tutor_Load(object sender, EventArgs e)
        {
            add_item();
        }

        private void btn_admdetutor_Click(object sender, EventArgs e)
        {
            string[] words = lb_admtutor.SelectedItem.ToString().Split("     ");
            string username = words[0];
            string name = words[1];
            MessageBox.Show(AdminClass.delete_employee("tutor", username, name));
            add_item();
            btn_admdetutor.Enabled = false;
            btn_admsetutor.Enabled = false;
        }
    }
}
