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
    public partial class LevelSubject_Monthly_income : Form
    {
        public LevelSubject_Monthly_income()
        {
            InitializeComponent();
        }

        private string insert_income(string lv,string sub,string month)
        {
            ArrayList lv_sub_in = new ArrayList();
            lv_sub_in = AdminClass.sub_level_income(lv,sub);
            int fee = 0;
            foreach (string[] a in lv_sub_in)
            {
                if (a[1] == month)
                {
                    fee = fee + int.Parse(a[0]);
                }
            }
            string income = fee.ToString();
            return income;
        }

        private void LevelSubject_Monthly_income_Load(object sender, EventArgs e)
        {
            ArrayList lv_sub = new ArrayList();
            lv_sub = AdminClass.sub_level();
            foreach (string[] ls in lv_sub)
            {
                label2.Text = label2.Text + ls[0] + "\n";
                label3.Text = label3.Text + ls[1] + "\n";
                january.Text = january.Text + insert_income(ls[0], ls[1],"January") + "\n";
                february.Text = february.Text + insert_income(ls[0], ls[1], "February") + "\n";
                march.Text = march.Text + insert_income(ls[0], ls[1], "March") + "\n";
                april.Text = april.Text + insert_income(ls[0], ls[1], "April") + "\n";
                may.Text = may.Text + insert_income(ls[0], ls[1], "May") + "\n";
                june.Text = june.Text + insert_income(ls[0], ls[1], "June") + "\n";
                july.Text = july.Text + insert_income(ls[0], ls[1], "July") + "\n";
                august.Text = august.Text + insert_income(ls[0], ls[1], "August") + "\n";
                september.Text = september.Text + insert_income(ls[0], ls[1], "September") + "\n";
                october.Text = october.Text + insert_income(ls[0], ls[1], "October") + "\n";
                november.Text = november.Text + insert_income(ls[0], ls[1], "November") + "\n";
                december.Text = december.Text + insert_income(ls[0], ls[1], "December") + "\n";
            }
        }

        private void btn_lvsub_in_back_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
