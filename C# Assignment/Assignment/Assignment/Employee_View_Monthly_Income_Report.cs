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
    public partial class Employee_View_Monthly_Income_Report : Form
    {
        public string username;
        public string name;
        public Employee_View_Monthly_Income_Report(string un,string na)
        {
            InitializeComponent();
            username = un;
            name = na;
        }

        private void btn_inback_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void View_Monthly_Income_Report_Load(object sender, EventArgs e)
        {
            lbl_inname.Text = name;
            string[] inc = AdminClass.view_employee_income(username);
            income1.Text = inc[0];
            income2.Text = inc[1];
            income3.Text = inc[2];
            income4.Text = inc[3];
            income5.Text = inc[4];
            income6.Text = inc[5];
            income7.Text = inc[6];
            income8.Text = inc[7];
            income9.Text = inc[8];
            income10.Text = inc[9];
            income11.Text = inc[10];
            income12.Text = inc[11];
            income13.Text = inc[12];
            income14.Text = inc[13];
            income15.Text = inc[14];
        }

        private void btn_inupdate_Click(object sender, EventArgs e)
        {
            string[] income = new string[12];
            income[0] = income4.Text;
            income[1] = income5.Text;
            income[2] = income6.Text;
            income[3] = income7.Text;
            income[4] = income8.Text;
            income[5] = income9.Text;
            income[6] = income10.Text;
            income[7] = income11.Text;
            income[8] = income12.Text;
            income[9] = income13.Text;
            income[10] = income14.Text;
            income[11] = income15.Text;

            MessageBox.Show(AdminClass.update_employee_income(username, income));
            this.Close();
        }
    }
}
