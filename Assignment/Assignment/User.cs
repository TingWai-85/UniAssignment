using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment
{
    internal class User
    {
        private string username;
        private string password;

        public User(string u, string p)
        {
            username = u;
            password = p;
        }

        public string login(string un)
        {
            string status = null;
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["myCs"].ToString());
            con.Open();

            //SqlCommand objectName = new Constructor(sqlQuery, connectionString);
            SqlCommand cmd = new SqlCommand("select count(*) from users where username ='" + username + "' and password ='" + password + "'", con);

            int count = Convert.ToInt32(cmd.ExecuteScalar().ToString());

            if (count > 0)
            {
                SqlCommand cmd2 = new SqlCommand("select role from users where username = '" + username + "' and password= '" + password + "'", con);
                string userRole = cmd2.ExecuteScalar().ToString();
                if (userRole == "admin")
                {
                    Admin a = new Admin(un);
                    a.ShowDialog();
                }
            }
            else
            {
                status = "Incorrect username or password";
            }
            con.Close();

            return status;
        }
    }
}
