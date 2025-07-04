using System;
using System.Collections;
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

namespace Assignment
{
    public partial class Employee_Monthly_Income_Report : Form
    {
        public Employee_Monthly_Income_Report()
        {
            InitializeComponent();
        }

        private void tutor_list_update()
        {
            //update the list of the tutor in the list box
            ArrayList tutor = new ArrayList();
            tutor = AdminClass.view_all_name("tutor");
            foreach (var tu in tutor)
            {
                lb_inname.Items.Add(tu);
            }
        }

        private void recep_list_update()
        {
            //update the list of the receptionist in the list box
            ArrayList recep = new ArrayList();
            recep = AdminClass.view_all_name("receptionist");
            foreach (var re in recep)
            {
                lb_inname.Items.Add(re);
            }
        }

        private void cb_inposition_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cb_inposition.SelectedIndex == 1)
            {
                cb_inlevel.Enabled = false;
                cb_insub.Enabled = false;
                lb_inname.Items.Clear();
                recep_list_update();
            }
            else
            {
                cb_inlevel.Enabled = true;
                cb_insub.Enabled = true;
                lb_inname.Items.Clear();
                tutor_list_update();
            }
        }

        private void btn_inview_Click_1(object sender, EventArgs e)
        {
            string[] words = lb_inname.SelectedItem.ToString().Split("     ");
            Employee_View_Monthly_Income_Report obj1 = new Employee_View_Monthly_Income_Report(words[0], words[1]);
            obj1.ShowDialog();
        }

        private void btn_inback_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void lb_inname_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lb_inname.SelectedIndex != -1)
            {
                btn_inview.Enabled = true;
            }
            else
            {
                btn_inview.Enabled = false;
            }
        }

        private void Monthly_Income_Report_Load(object sender, EventArgs e)
        {
            tutor_list_update();
            recep_list_update();
        }
        private void cb_insub_SelectedIndexChanged(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["myCS"].ToString());
            con.Open();
            string subject = cb_insub.SelectedItem.ToString();
            if (cb_inlevel.SelectedItem != null)
            {
                string level = cb_inlevel.SelectedItem.ToString().Substring(5);
                Int32 lv = Int32.Parse(level);
                SqlCommand cmd = new SqlCommand("select Username,Name from tutor_subject where Level = " + lv + " and Subject = '" + subject + "'", con);
                SqlDataReader rd = cmd.ExecuteReader();
                lb_inname.Items.Clear();
                while (rd.Read())
                {
                    lb_inname.Items.Add(rd.GetString(0)+"     "+rd.GetString(1));
                }
            }
            else
            {
                SqlCommand cmd = new SqlCommand("select Username,Name from tutor_subject where Subject = '" + subject + "'", con);
                SqlDataReader rd = cmd.ExecuteReader();
                lb_inname.Items.Clear();
                while (rd.Read())
                {
                    lb_inname.Items.Add(rd.GetString(0) + "     " + rd.GetString(1));
                }
            }
        }

        private void cb_inlevel_SelectedIndexChanged(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["myCS"].ToString());
            con.Open();
            string level = cb_inlevel.SelectedItem.ToString().Substring(5);
            Int32 lv = Int32.Parse(level);
            if (cb_insub.SelectedItem!= null)
            {
                string subject = cb_insub.SelectedItem.ToString();
                SqlCommand cmd = new SqlCommand("select Username,Name from tutor_subject where Level = " + lv + " and Subject = '" + subject + "'", con);
                SqlDataReader rd = cmd.ExecuteReader();
                lb_inname.Items.Clear();
                while (rd.Read())
                {
                    lb_inname.Items.Add(rd.GetString(0) + "     " + rd.GetString(1));
                }
            }
            else
            {
                SqlCommand cmd = new SqlCommand("select Username,Name from tutor_subject where Level = " + lv , con);
                SqlDataReader rd = cmd.ExecuteReader();
                lb_inname.Items.Clear();
                while (rd.Read())
                {
                    lb_inname.Items.Add(rd.GetString(0) + "     " + rd.GetString(1));
                }
            }
        }
    }
}
