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
    public partial class Admin_Register : Form
    {
        public Admin_Register()
        {
            InitializeComponent();
            cb_admregcountry.SelectedItem = "Malaysia";
            cb_admregposition.SelectedIndex= 0;
        }

        private void cb_admregcountry_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cb_admregcountry.SelectedItem == "Malaysia")
            {
                mktxt_admregIC.Mask = "000000-00-0000";
            }
            else
            {
                mktxt_admregIC.Mask = null;
            }
        }

        private void btn_admreg_Click(object sender, EventArgs e)
        {
            if (txt_admregname.Text != "" && txt_admregemail.Text != "" && txt_admregemail2.Text != "" && txt_admregaddress.Text != "" && mktxt_admregcontactt.Text != "  -   -" && mktxt_admregIC.Text != "      -  -")
            {
                string name = txt_admregname.Text;
                string country = cb_admregcountry.SelectedItem.ToString();
                string ic = mktxt_admregIC.Text.Remove(6, 1).Remove(8, 1);
                string register_gender;
                string email = txt_admregemail.Text + "@" + txt_admregemail2.Text + ".com";
                string phone = "60" + mktxt_admregcontactt.Text.Remove(2, 1).Remove(5, 1);
                string position = cb_admregposition.SelectedItem.ToString();
                string address = txt_admregaddress.Text;
                if (rdbtn_admregmale.Checked)
                {
                    register_gender = "Male";
                }
                else
                {
                    register_gender = "Female";
                }

                MessageBox.Show(AdminClass.Register(name, country, ic, register_gender, email, phone, address, position));
            }
            else
            {
                MessageBox.Show("Sorry, please complete the detail");
            }
        }

        private void btn_admcancelreg_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
