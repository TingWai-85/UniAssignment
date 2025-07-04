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
    public partial class Update_Personal_Detail : Form
    {
        public static string username;
        public Update_Personal_Detail(string un)
        {
            InitializeComponent();
            username = un;
            cb_admcountry.SelectedItem = "Malaysia";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Update_Personal_Detail_Load(object sender, EventArgs e)
        {
            ArrayList admin_detail = new ArrayList();
            AdminClass admin = new AdminClass(username);
            admin_detail = admin.view_admin_detail(username);
            lbl_admupdatename.Text = admin_detail[0].ToString();
            cb_admcountry.Text = admin_detail[1].ToString();
            label11.Text = admin_detail[2].ToString();
            label4.Text = admin_detail[3].ToString();
            txt_admemail.Text = admin_detail[4].ToString();
            mktxt_admcontact.Text = admin_detail[5].ToString().Substring(2);
            txt_admaddress.Text = admin_detail[6].ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (txt_admemail.Text.ToString().Contains("@") == true && txt_admemail.Text.ToString().Contains(".")== true)
            {
                string phone = "60" + mktxt_admcontact.Text.Remove(2, 1);
                string updatedphone = phone.Remove(7, 1);
                AdminClass admin = new AdminClass(username);
                MessageBox.Show(admin.updateProfile(cb_admcountry.Text, txt_admemail.Text, updatedphone, txt_admaddress.Text));
                this.Close();
            }
            else
            {
                MessageBox.Show("Update unsuccessful! Your email should contain '@' and '.'");
            }
        }
    }
}
