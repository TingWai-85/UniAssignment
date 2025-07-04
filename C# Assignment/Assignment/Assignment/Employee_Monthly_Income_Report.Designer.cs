namespace Assignment
{
    partial class Employee_Monthly_Income_Report
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.panel1 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.cb_inposition = new System.Windows.Forms.ComboBox();
            this.lb_inname = new System.Windows.Forms.ListBox();
            this.btn_inview = new System.Windows.Forms.Button();
            this.btn_inback = new System.Windows.Forms.Button();
            this.cb_insub = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.cb_inlevel = new System.Windows.Forms.ComboBox();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.Info;
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(-2, -1);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(805, 72);
            this.panel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Viner Hand ITC", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(0, 20);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(245, 32);
            this.label1.TabIndex = 0;
            this.label1.Text = "Excellent Tuition Center";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(28, 87);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(64, 20);
            this.label2.TabIndex = 1;
            this.label2.Text = "Position:";
            // 
            // cb_inposition
            // 
            this.cb_inposition.FormattingEnabled = true;
            this.cb_inposition.Items.AddRange(new object[] {
            "Tutor",
            "Receptionist"});
            this.cb_inposition.Location = new System.Drawing.Point(98, 84);
            this.cb_inposition.Name = "cb_inposition";
            this.cb_inposition.Size = new System.Drawing.Size(151, 28);
            this.cb_inposition.TabIndex = 4;
            this.cb_inposition.SelectedIndexChanged += new System.EventHandler(this.cb_inposition_SelectedIndexChanged);
            // 
            // lb_inname
            // 
            this.lb_inname.FormattingEnabled = true;
            this.lb_inname.ItemHeight = 20;
            this.lb_inname.Location = new System.Drawing.Point(28, 133);
            this.lb_inname.Name = "lb_inname";
            this.lb_inname.Size = new System.Drawing.Size(683, 164);
            this.lb_inname.TabIndex = 7;
            this.lb_inname.SelectedIndexChanged += new System.EventHandler(this.lb_inname_SelectedIndexChanged);
            // 
            // btn_inview
            // 
            this.btn_inview.Enabled = false;
            this.btn_inview.Location = new System.Drawing.Point(114, 322);
            this.btn_inview.Name = "btn_inview";
            this.btn_inview.Size = new System.Drawing.Size(214, 29);
            this.btn_inview.TabIndex = 8;
            this.btn_inview.Text = "View Monthly Income Report";
            this.btn_inview.UseVisualStyleBackColor = true;
            this.btn_inview.Click += new System.EventHandler(this.btn_inview_Click_1);
            // 
            // btn_inback
            // 
            this.btn_inback.Location = new System.Drawing.Point(400, 322);
            this.btn_inback.Name = "btn_inback";
            this.btn_inback.Size = new System.Drawing.Size(214, 29);
            this.btn_inback.TabIndex = 9;
            this.btn_inback.Text = "Back";
            this.btn_inback.UseVisualStyleBackColor = true;
            this.btn_inback.Click += new System.EventHandler(this.btn_inback_Click);
            // 
            // cb_insub
            // 
            this.cb_insub.FormattingEnabled = true;
            this.cb_insub.Items.AddRange(new object[] {
            "Chinese Language",
            "English Language",
            "Malay Language",
            "Mathematic",
            "Additional Mathematic",
            "Physic",
            "Biology",
            "Chemistry",
            "Science",
            "Accounting",
            "Economy"});
            this.cb_insub.Location = new System.Drawing.Point(560, 89);
            this.cb_insub.Name = "cb_insub";
            this.cb_insub.Size = new System.Drawing.Size(151, 28);
            this.cb_insub.TabIndex = 6;
            this.cb_insub.SelectedIndexChanged += new System.EventHandler(this.cb_insub_SelectedIndexChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(493, 92);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(61, 20);
            this.label4.TabIndex = 3;
            this.label4.Text = "Subject:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(265, 92);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(46, 20);
            this.label3.TabIndex = 2;
            this.label3.Text = "Level:";
            // 
            // cb_inlevel
            // 
            this.cb_inlevel.FormattingEnabled = true;
            this.cb_inlevel.Items.AddRange(new object[] {
            "Form 1",
            "Form 2",
            "Form 3",
            "Form 4",
            "Form 5"});
            this.cb_inlevel.Location = new System.Drawing.Point(317, 87);
            this.cb_inlevel.Name = "cb_inlevel";
            this.cb_inlevel.Size = new System.Drawing.Size(151, 28);
            this.cb_inlevel.TabIndex = 5;
            this.cb_inlevel.SelectedIndexChanged += new System.EventHandler(this.cb_inlevel_SelectedIndexChanged);
            // 
            // Monthly_Income_Report
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(748, 393);
            this.Controls.Add(this.btn_inback);
            this.Controls.Add(this.btn_inview);
            this.Controls.Add(this.lb_inname);
            this.Controls.Add(this.cb_insub);
            this.Controls.Add(this.cb_inlevel);
            this.Controls.Add(this.cb_inposition);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.panel1);
            this.Name = "Monthly_Income_Report";
            this.Text = "Admin - Monthly Income Report";
            this.Load += new System.EventHandler(this.Monthly_Income_Report_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Panel panel1;
        private Label label1;
        private Label label2;
        private ComboBox cb_inposition;
        private ListBox lb_inname;
        private Button btn_inview;
        private Button btn_inback;
        private ComboBox cb_insub;
        private Label label4;
        private Label label3;
        private ComboBox cb_inlevel;
    }
}