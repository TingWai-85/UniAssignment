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
    public partial class Admin_Receptionist : Form
    {
        public Admin_Receptionist()
        {
            InitializeComponent();
        }

        private void add_item()
        {
            //this fuction is to adding the name of the tutor into the list box
            lb_admrecep.Items.Clear();
            ArrayList all_recep = new ArrayList();
            all_recep = AdminClass.view_all_name("receptionist");

            foreach (var name in all_recep)
            {
                lb_admrecep.Items.Add(name);
            }
        }

        private void lb_admrecep_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lb_admrecep.SelectedIndex != -1)
            {
                btn_admderecep.Enabled = true;
            }
            else
            {
                btn_admderecep.Enabled = false;
            }
        }

        private void btn_admrerecep_Click(object sender, EventArgs e)
        {
            Admin_Register obj1 = new Admin_Register();
            obj1.ShowDialog();
            add_item();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Admin_Receptionist_Load(object sender, EventArgs e)
        {
            add_item();
        }

        private void btn_admderecep_Click(object sender, EventArgs e)
        {
            string[] words = lb_admrecep.SelectedItem.ToString().Split("     ");
            string username = words[0];
            string name = words[1];
            MessageBox.Show(AdminClass.delete_employee("receptionist", username, name));
            add_item();
            btn_admderecep.Enabled = false;
        }
    }
}
