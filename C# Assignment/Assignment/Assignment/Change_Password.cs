using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

namespace Assignment
{
    public partial class Change_Password : Form
    {
        public static string username;
        public Change_Password(string un)
        {
            InitializeComponent();
            username = un;
        }

        private string password_validation(string original,string newpassword,string repeatpass)
        {
            string notify;
            int stringlength = newpassword.Length;
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["myCS"].ToString());
            con.Open();
            SqlCommand cmd = new SqlCommand("select password from users where username = '" + username + "'", con);
            string oripass = cmd.ExecuteScalar().ToString();
            if (original != oripass)
            {
                notify = "Your original password is incorrect";
            }
            else if (repeatpass != newpassword)
            {
                notify = "Your confirm new password is not same with your new password";
            }
            else if (stringlength < 8)
            {
                notify = "Your password should have at lease 8 characters";
            }
            else if (newpassword == original)
            {
                notify = "Your new password cannot same with your original password";
            }
            else
            {
                notify = "";
            }
            con.Close();

            return notify;
        }

        private void ckbox_admshowpass_CheckedChanged(object sender, EventArgs e)
        {
            if (ckbox_admshowpass.Checked == true) 
            {
                txt_admoripass.PasswordChar = '\0';
                txt_admnewpass.PasswordChar = '\0';
                txt_admrepeatpass.PasswordChar = '\0';
            }
            else
            {
                txt_admoripass.PasswordChar = '*';
                txt_admnewpass.PasswordChar= '*';
                txt_admrepeatpass.PasswordChar = '*';
            }
        }

        private void txt_admrepeatpass_TextChanged(object sender, EventArgs e)
        {
            lbl_admpassnotify.Text = password_validation(txt_admoripass.Text,txt_admnewpass.Text,txt_admrepeatpass.Text);
        }

        private void txt_admnewpass_TextChanged(object sender, EventArgs e)
        {
            lbl_admpassnotify.Text = password_validation(txt_admoripass.Text, txt_admnewpass.Text, txt_admrepeatpass.Text);
        }

        private void btn_admcancelupdatepass_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btn_updatepass_Click(object sender, EventArgs e)
        {
            if (lbl_admpassnotify.Text != "")
            {
                MessageBox.Show(lbl_admpassnotify.Text);
            }
            else if (txt_admoripass.Text == "" || txt_admnewpass.Text == "" || txt_admrepeatpass.Text == "")
            {
                MessageBox.Show("The box cannot leave blank");
            }
            else
            {
                AdminClass admin = new AdminClass(username);
                MessageBox.Show(admin.changePassword(txt_admrepeatpass.Text));
                this.Close();
            }
        }

        private void txt_admoripass_TextChanged(object sender, EventArgs e)
        {
            lbl_admpassnotify.Text = password_validation(txt_admoripass.Text, txt_admnewpass.Text, txt_admrepeatpass.Text);
        }
    }
}
