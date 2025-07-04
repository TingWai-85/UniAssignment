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
    public partial class login : Form
    {
        public login()
        {
            InitializeComponent();
        }

        private void btnlogin_Click(object sender, EventArgs e)
        {
            string stat;
            User obj1 = new User(txtusername.Text, txtpassword.Text);
            stat = obj1.login(txtusername.Text);
            if (stat != null)
            {
                MessageBox.Show(stat);
            }
            txtusername.Text = String.Empty;
            txtpassword.Text = String.Empty;
        }
    }
}
