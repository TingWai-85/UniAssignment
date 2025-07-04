namespace Assignment
{
    partial class Admin_Tutor_AddSubject
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
            this.label3 = new System.Windows.Forms.Label();
            this.cb_admtutorlevel = new System.Windows.Forms.ComboBox();
            this.cb_admtutorsub = new System.Windows.Forms.ComboBox();
            this.btn_admtutoraddlvsub = new System.Windows.Forms.Button();
            this.btn_admtutorcancellvsub = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.Info;
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(-2, -1);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(447, 61);
            this.panel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Viner Hand ITC", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(0, 10);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(245, 32);
            this.label1.TabIndex = 0;
            this.label1.Text = "Excellent Tuition Center";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(109, 80);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(60, 28);
            this.label2.TabIndex = 1;
            this.label2.Text = "Level:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label3.Location = new System.Drawing.Point(88, 127);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(81, 28);
            this.label3.TabIndex = 2;
            this.label3.Text = "Subject:";
            // 
            // cb_admtutorlevel
            // 
            this.cb_admtutorlevel.FormattingEnabled = true;
            this.cb_admtutorlevel.Items.AddRange(new object[] {
            "Form 1",
            "Form 2",
            "Form 3",
            "Form 4",
            "Form 5"});
            this.cb_admtutorlevel.Location = new System.Drawing.Point(216, 84);
            this.cb_admtutorlevel.Name = "cb_admtutorlevel";
            this.cb_admtutorlevel.Size = new System.Drawing.Size(151, 28);
            this.cb_admtutorlevel.TabIndex = 3;
            this.cb_admtutorlevel.SelectedIndexChanged += new System.EventHandler(this.cb_admtutorlevel_SelectedIndexChanged);
            // 
            // cb_admtutorsub
            // 
            this.cb_admtutorsub.FormattingEnabled = true;
            this.cb_admtutorsub.Items.AddRange(new object[] {
            "Mathematic",
            "English",
            "Science"});
            this.cb_admtutorsub.Location = new System.Drawing.Point(216, 127);
            this.cb_admtutorsub.Name = "cb_admtutorsub";
            this.cb_admtutorsub.Size = new System.Drawing.Size(151, 28);
            this.cb_admtutorsub.TabIndex = 4;
            this.cb_admtutorsub.SelectedIndexChanged += new System.EventHandler(this.cb_admtutorsub_SelectedIndexChanged);
            // 
            // btn_admtutoraddlvsub
            // 
            this.btn_admtutoraddlvsub.Enabled = false;
            this.btn_admtutoraddlvsub.Location = new System.Drawing.Point(122, 181);
            this.btn_admtutoraddlvsub.Name = "btn_admtutoraddlvsub";
            this.btn_admtutoraddlvsub.Size = new System.Drawing.Size(94, 29);
            this.btn_admtutoraddlvsub.TabIndex = 5;
            this.btn_admtutoraddlvsub.Text = "Add";
            this.btn_admtutoraddlvsub.UseVisualStyleBackColor = true;
            this.btn_admtutoraddlvsub.Click += new System.EventHandler(this.btn_admtutoraddlvsub_Click);
            // 
            // btn_admtutorcancellvsub
            // 
            this.btn_admtutorcancellvsub.Location = new System.Drawing.Point(273, 181);
            this.btn_admtutorcancellvsub.Name = "btn_admtutorcancellvsub";
            this.btn_admtutorcancellvsub.Size = new System.Drawing.Size(94, 29);
            this.btn_admtutorcancellvsub.TabIndex = 6;
            this.btn_admtutorcancellvsub.Text = "Cancel";
            this.btn_admtutorcancellvsub.UseVisualStyleBackColor = true;
            this.btn_admtutorcancellvsub.Click += new System.EventHandler(this.btn_admtutorcancellvsub_Click);
            // 
            // Admin_Tutor_AddSubject
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(444, 257);
            this.Controls.Add(this.btn_admtutorcancellvsub);
            this.Controls.Add(this.btn_admtutoraddlvsub);
            this.Controls.Add(this.cb_admtutorsub);
            this.Controls.Add(this.cb_admtutorlevel);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.panel1);
            this.Name = "Admin_Tutor_AddSubject";
            this.Text = "Admin - Tutor -";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Panel panel1;
        private Label label1;
        private Label label2;
        private Label label3;
        private ComboBox cb_admtutorlevel;
        private ComboBox cb_admtutorsub;
        private Button btn_admtutoraddlvsub;
        private Button btn_admtutorcancellvsub;
    }
}