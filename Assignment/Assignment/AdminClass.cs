using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel.Design.Serialization;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ListView;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

namespace Assignment
{
    internal class AdminClass
    {
        public string adminusername;
        private string adminpassword;
        private string country;
        private string email;
        private string phone;
        private string address;
        static SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["myCS"].ToString());

        public string Country { get => country; set => country = value; }
        public string Email { get => email; set => email = value; }
        public string Phone { get => phone; set => phone = value; }
        public string Address { get => address; set => address = value; }

        public AdminClass(string un)
        {
            adminusername = un;
        }

        public string updateProfile(string co, string em, string num,string add)
        {
            string status;
            con.Open();
            country = co;
            email = em;
            phone = num;
            address = add;

            SqlCommand cmd = new SqlCommand("update admin set adminCountry ='" + country + "',adminEmail ='"+email+"',adminPhone ='"+num+"',adminAddress = '"+add+"' where adminUsername ='" + adminusername + "'", con);
            int i = cmd.ExecuteNonQuery();
            if (i != 0)
            {
                status = "Update Successfully.";
            }
            else
            {
                status = "Unable to update";
            }

            con.Close();

            return status;
        }

        public string changePassword(string pass)
        {
            string status;
            con.Open();
            adminpassword = pass;

            SqlCommand cmd = new SqlCommand("update users set password ='" + adminpassword + "' where username ='" + adminusername + "'", con);
            int i = cmd.ExecuteNonQuery();
            if (i != 0)
            {
                status = "Update Successfully.";
            }
            else
            {
                status = "Unable to update";
            }

            con.Close();

            return status;
        }
        public ArrayList view_admin_detail(string un)
        {
            ArrayList detail = new ArrayList();
            con.Open();
            SqlCommand cmd = new SqlCommand("select * from admin where adminUsername = '" + adminusername + "'", con);
            SqlDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                detail.Add(rd.GetString(2));
                detail.Add(rd.GetString(3));
                detail.Add(rd.GetString(4));
                detail.Add(rd.GetString(5));
                detail.Add(rd.GetString(6));
                detail.Add(rd.GetString(7));
                detail.Add(rd.GetString(8));
            }
            con.Close();
            return detail;
        }

        public static ArrayList view_all_name(string position)
        {
            //this function is to diaplay all the username and name of the tutor or receptionist
            ArrayList employee = new ArrayList();
            con.Open();
            SqlCommand cmd = new SqlCommand("select Username,Name from "+ position, con);
            SqlDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                string full;
                full = rd.GetString(0) + "     " + rd.GetString(1);
                employee.Add(full);
            }
            con.Close();
            return employee;
        }

        public static ArrayList view_tutor_subject(string un)
        {
            ArrayList subject = new ArrayList();
            con.Open();
            SqlCommand cmd = new SqlCommand("select Level,Subject from tutor_subject where Username = '" + un + "'", con);
            SqlDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                string full;
                full = "Form "+ rd.GetInt32(0).ToString() + "     " + rd.GetString(1);
                subject.Add(full);
            }
            con.Close();
            subject.Sort();
            return subject;
        }

        public static string add_subject(string username,string name,Int32 lv,string sub)
        {
            string state;
            con.Open();
            SqlCommand cmd = new SqlCommand("insert into tutor_subject (Username,Name,Level,Subject) values (@un,@na,@lv,@sub)", con);
            cmd.Parameters.AddWithValue("@un", username);
            cmd.Parameters.AddWithValue("@na", name);
            cmd.Parameters.AddWithValue("@lv", lv);
            cmd.Parameters.AddWithValue("@sub", sub);
            int i = cmd.ExecuteNonQuery();
            if (i != 0)
            {
                state = "Assign Successfully";
            }
            else
            {
                state = "Unsuccessful";
            }
            con.Close();
            return state;
        }

        public static string delete_subject(string un,string lv,string sub)
        {
            string state;
            con.Open();
            SqlCommand cmd = new SqlCommand("delete from tutor_subject where Username = '" + un + "' and Level = '" + lv + "' and Subject ='"+sub+"'", con);
            int i = cmd.ExecuteNonQuery();
            if (i != 0)
            {
                state = "Delete Successfully";
            }
            else
            {
                state = "Unsuccessful";
            }
            con.Close();
            return state;
        }

        public static string delete_employee(string position,string un,string name)
        {
            string state;
            con.Open();
            SqlCommand cmd = new SqlCommand("delete from " + position + " where Username = '" + un + "' and Name = '" + name + "'",con);
            SqlCommand cmd1 = new SqlCommand("delete from users where Username = '" + un + "'", con);
            SqlCommand cmd2 = new SqlCommand("delete from income where Username = '" + un + "'", con);
            if (position == "tutor")
            {
                SqlCommand cmd3 = new SqlCommand("delete from tutor_subject where Username = '" + un + "'", con);
                cmd3.ExecuteNonQuery();
            }
            int i = cmd.ExecuteNonQuery();
            int i1 = cmd1.ExecuteNonQuery();
            int i2 = cmd2.ExecuteNonQuery();
            if (i != 0 && i1 !=0 && i2 != 0)
            {
                state = "Delete Successfully";
            }
            else
            {
                state = "Unsuccessful";
            }
            con.Close();
            return state;
        }

        private static string register(string pos,string name,string co,string ic,string ge, string em, string ph, string add)
        {
            string status;
            string username;
            con.Open();
            try
            {
                SqlCommand cmd = new SqlCommand("select max(Id) from "+pos, con);
                int number = (int.Parse(cmd.ExecuteScalar().ToString())) + 1;
                username = pos + number;
            }
            catch
            {
                username = pos + "1";
            }
            SqlCommand cmd1 = new SqlCommand("insert into " + pos + " (Username,Name,Country,IC,Gender,Email,Phone,Address) values (@un,@n,@co,@ic,@ge,@em,@ph,@add)", con);
            SqlCommand cmd2 = new SqlCommand("insert into users (username,password,role) values (@un,'123456789',@ro)", con);
            if (pos == "tutor")
            {
                SqlCommand cmd3 = new SqlCommand("insert into income values (@un,'Tutor',0,0,0,0,0,0,0,0,0,0,0,0,0)", con);
                cmd3.Parameters.AddWithValue("@un", username);
                cmd3.ExecuteNonQuery();
            }
            else
            {
                SqlCommand cmd3 = new SqlCommand("insert into income values (@un,'Receptionist',0,0,0,0,0,0,0,0,0,0,0,0,0)", con);
                cmd3.Parameters.AddWithValue("@un", username);
                cmd3.ExecuteNonQuery();
            }
            cmd1.Parameters.AddWithValue("@un", username);
            cmd1.Parameters.AddWithValue("@n", name);
            cmd1.Parameters.AddWithValue("@co", co);
            cmd1.Parameters.AddWithValue("@ic", ic);
            cmd1.Parameters.AddWithValue("@ge", ge);
            cmd1.Parameters.AddWithValue("@em", em);
            cmd1.Parameters.AddWithValue("@ph", ph);
            cmd1.Parameters.AddWithValue("@add", add);
            cmd2.Parameters.AddWithValue("@un", username);
            cmd2.Parameters.AddWithValue("@ro", pos);

            cmd2.ExecuteNonQuery();
            int i = cmd1.ExecuteNonQuery();
            if (i != 0)
            {
                status = "Registeration Successful\nPlease email the following detail to the tutor/receptionist:\nUsername :" + username + "\nTemporary Password :123456789\n(Inform the user to change their password once they have logged in)";
            }
            else
            {
                status = "Unable to register,please complete all the detail";
            }

            con.Close();
            return status;
        }
        public static string Register(string name,string country, string ic, string gender, string email, string phone, string address,string position)
        {
            if (position == "Tutor")
            {
                string sta;
                sta = register("tutor", name, country, ic, gender, email, phone, address);
                return sta;
            }
            else
            {
                string sta;
                sta = register("receptionist", name, country, ic, gender, email, phone, address);
                return sta;
            }
        }

        public static void update_income_subject(string username)
        {
            con.Open();
            SqlCommand cmd = new SqlCommand("select count(*) from tutor_subject where username ='" + username + "'", con);
            Int32 count = Convert.ToInt32(cmd.ExecuteScalar().ToString());
            SqlCommand cmd2 = new SqlCommand("update income set Total_Subject = @sub where Username ='" + username + "'", con);
            cmd2.Parameters.AddWithValue("@sub", count);
            cmd2.ExecuteNonQuery();
            con.Close();
        }

        public static string[] view_employee_income(string un)
        {
            string[] income = new string[15];
            con.Open();
            SqlCommand cmd = new SqlCommand("select Username,Role,Total_Subject,January,February,March,April,May,June,July,August,September,October,November,December from income where Username = '" + un + "'", con);
            SqlDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                income[0] = rd.GetString(0);
                income[1] = rd.GetString(1);
                income[2] = rd.GetInt32(2).ToString();
                int i = 3;
                while (i <= 14)
                {
                    income[i] = rd.GetDecimal(i).ToString("f2");
                    i = i + 1;
                }
            }
            con.Close();
            return income;
        }

        public static string update_employee_income(string username, string[] element)
        {
            string state;
            con.Open();
            SqlCommand cmd = new SqlCommand("update income set January = @ja, February = @fe, March = @ma, April = @ap, May = @may, June = @ju, July = @jul, August = @au, September = @se, October = @oc, November = @no, December = @de where Username = '"+ username + "'",con);
            cmd.Parameters.AddWithValue("@ja", element[0]);
            cmd.Parameters.AddWithValue("@fe", element[1]);
            cmd.Parameters.AddWithValue("@ma", element[2]);
            cmd.Parameters.AddWithValue("@ap", element[3]);
            cmd.Parameters.AddWithValue("@may", element[4]);
            cmd.Parameters.AddWithValue("@ju", element[5]);
            cmd.Parameters.AddWithValue("@jul", element[6]);
            cmd.Parameters.AddWithValue("@au", element[7]);
            cmd.Parameters.AddWithValue("@se", element[8]);
            cmd.Parameters.AddWithValue("@oc", element[9]);
            cmd.Parameters.AddWithValue("@no", element[10]);
            cmd.Parameters.AddWithValue("@de", element[11]);

            int i = cmd.ExecuteNonQuery();
            if (i !=0)
            {
                state = "Successful";
            }
            else
            {
                state = "Unsuccessful";
            }

            con.Close();
            return state;
        }

       private static ArrayList no_repeat_list(ArrayList a)
        {
            ArrayList no_repeat_element = new ArrayList();
            ArrayList no_repeat_string_list = new ArrayList();
            foreach (string b in a) //"Form 2     English"
            {
                if (no_repeat_element.Contains(b) == false)
                {
                    no_repeat_element.Add(b);
                }
            }
            foreach (string b in no_repeat_element)
            {
                string[] lv_sub = b.Split("     "); //{"Form 2","English"}

                no_repeat_string_list.Add(lv_sub);
            }

            return no_repeat_string_list;
        }
        public static ArrayList sub_level()
        {
            ArrayList subject = new ArrayList();
            con.Open();
            SqlCommand cmd = new SqlCommand("select level_payment,subject_payment from payment", con);
            SqlDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                string full = rd.GetString(0) + "     " + rd.GetString(1); //"Form 2     English"
                subject.Add(full);
            }
            con.Close();
            ArrayList no_repeat_sub = new ArrayList();
            no_repeat_sub = no_repeat_list(subject);
            return no_repeat_sub;
        }

        public static ArrayList sub_level_income(string level,string sub)
        {
            ArrayList subject = new ArrayList();
            con.Open(); 
            SqlCommand cmd = new SqlCommand("select totalFee_payment,month_payment from payment where level_payment = '"+level+ "' and subject_payment = '"+sub+"'", con);
            SqlDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                string[] lv_sub = new string[2];
                lv_sub[0] = rd.GetString(0);
                lv_sub[1] = rd.GetString(1);
                subject.Add(lv_sub); //{"50","January"}
            }
            con.Close();
            return subject;
        }
    }
}
