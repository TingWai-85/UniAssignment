﻿using System;
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
    public partial class Monthly_income : Form
    {
        public Monthly_income()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Employee_Monthly_Income_Report obj1 = new Employee_Monthly_Income_Report();
            obj1.ShowDialog();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            LevelSubject_Monthly_income obj1 = new LevelSubject_Monthly_income();
            obj1.ShowDialog();
        }
    }
}
