namespace Assignment
{
    partial class Change_Password
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
            this.panel2 = new System.Windows.Forms.Panel();
            this.lbl_admpassnotify = new System.Windows.Forms.Label();
            this.ckbox_admshowpass = new System.Windows.Forms.CheckBox();
            this.label6 = new System.Windows.Forms.Label();
            this.txt_admrepeatpass = new System.Windows.Forms.TextBox();
            this.txt_admnewpass = new System.Windows.Forms.TextBox();
            this.txt_admoripass = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.btn_updatepass = new System.Windows.Forms.Button();
            this.btn_admcancelupdatepass = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.Info;
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(545, 63);
            this.panel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Viner Hand ITC", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(0, 19);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(269, 32);
            this.label1.TabIndex = 0;
            this.label1.Text = "Excellent Tuition Center";
            // 
            // panel2
            // 
            this.panel2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel2.Controls.Add(this.lbl_admpassnotify);
            this.panel2.Controls.Add(this.ckbox_admshowpass);
            this.panel2.Controls.Add(this.label6);
            this.panel2.Controls.Add(this.txt_admrepeatpass);
            this.panel2.Controls.Add(this.txt_admnewpass);
            this.panel2.Controls.Add(this.txt_admoripass);
            this.panel2.Controls.Add(this.label5);
            this.panel2.Controls.Add(this.label4);
            this.panel2.Controls.Add(this.label3);
            this.panel2.Controls.Add(this.label2);
            this.panel2.Location = new System.Drawing.Point(54, 83);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(448, 237);
            this.panel2.TabIndex = 1;
            // 
            // lbl_admpassnotify
            // 
            this.lbl_admpassnotify.AutoSize = true;
            this.lbl_admpassnotify.ForeColor = System.Drawing.Color.Red;
            this.lbl_admpassnotify.Location = new System.Drawing.Point(10, 187);
            this.lbl_admpassnotify.Name = "lbl_admpassnotify";
            this.lbl_admpassnotify.Size = new System.Drawing.Size(0, 20);
            this.lbl_admpassnotify.TabIndex = 10;
            // 
            // ckbox_admshowpass
            // 
            this.ckbox_admshowpass.AutoSize = true;
            this.ckbox_admshowpass.CheckAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.ckbox_admshowpass.Location = new System.Drawing.Point(215, 160);
            this.ckbox_admshowpass.Name = "ckbox_admshowpass";
            this.ckbox_admshowpass.Size = new System.Drawing.Size(132, 24);
            this.ckbox_admshowpass.TabIndex = 9;
            this.ckbox_admshowpass.Text = "Show Password";
            this.ckbox_admshowpass.UseVisualStyleBackColor = true;
            this.ckbox_admshowpass.CheckedChanged += new System.EventHandler(this.ckbox_admshowpass_CheckedChanged);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.BackColor = System.Drawing.SystemColors.HighlightText;
            this.label6.ForeColor = System.Drawing.Color.Red;
            this.label6.Location = new System.Drawing.Point(46, 37);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(363, 20);
            this.label6.TabIndex = 7;
            this.label6.Text = "Note: Your password should have at least 8 characters";
            // 
            // txt_admrepeatpass
            // 
            this.txt_admrepeatpass.Location = new System.Drawing.Point(182, 130);
            this.txt_admrepeatpass.Name = "txt_admrepeatpass";
            this.txt_admrepeatpass.PasswordChar = '*';
            this.txt_admrepeatpass.Size = new System.Drawing.Size(249, 27);
            this.txt_admrepeatpass.TabIndex = 6;
            this.txt_admrepeatpass.TextChanged += new System.EventHandler(this.txt_admrepeatpass_TextChanged);
            // 
            // txt_admnewpass
            // 
            this.txt_admnewpass.Location = new System.Drawing.Point(182, 97);
            this.txt_admnewpass.Name = "txt_admnewpass";
            this.txt_admnewpass.PasswordChar = '*';
            this.txt_admnewpass.Size = new System.Drawing.Size(249, 27);
            this.txt_admnewpass.TabIndex = 5;
            this.txt_admnewpass.TextChanged += new System.EventHandler(this.txt_admnewpass_TextChanged);
            // 
            // txt_admoripass
            // 
            this.txt_admoripass.Location = new System.Drawing.Point(182, 69);
            this.txt_admoripass.Name = "txt_admoripass";
            this.txt_admoripass.PasswordChar = '*';
            this.txt_admoripass.Size = new System.Drawing.Size(249, 27);
            this.txt_admoripass.TabIndex = 4;
            this.txt_admoripass.TextChanged += new System.EventHandler(this.txt_admoripass_TextChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(12, 130);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(164, 20);
            this.label5.TabIndex = 3;
            this.label5.Text = "Confirm New Password:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(69, 100);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(107, 20);
            this.label4.TabIndex = 2;
            this.label4.Text = "New Password:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(46, 72);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(130, 20);
            this.label3.TabIndex = 1;
            this.label3.Text = "Original Password:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(-1, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(177, 28);
            this.label2.TabIndex = 0;
            this.label2.Text = "Change Password";
            // 
            // btn_updatepass
            // 
            this.btn_updatepass.Location = new System.Drawing.Point(124, 326);
            this.btn_updatepass.Name = "btn_updatepass";
            this.btn_updatepass.Size = new System.Drawing.Size(119, 29);
            this.btn_updatepass.TabIndex = 2;
            this.btn_updatepass.Text = "Save Changes";
            this.btn_updatepass.UseVisualStyleBackColor = true;
            this.btn_updatepass.Click += new System.EventHandler(this.btn_updatepass_Click);
            // 
            // btn_admcancelupdatepass
            // 
            this.btn_admcancelupdatepass.Location = new System.Drawing.Point(270, 326);
            this.btn_admcancelupdatepass.Name = "btn_admcancelupdatepass";
            this.btn_admcancelupdatepass.Size = new System.Drawing.Size(119, 29);
            this.btn_admcancelupdatepass.TabIndex = 3;
            this.btn_admcancelupdatepass.Text = "Cancel";
            this.btn_admcancelupdatepass.UseVisualStyleBackColor = true;
            this.btn_admcancelupdatepass.Click += new System.EventHandler(this.btn_admcancelupdatepass_Click);
            // 
            // Change_Password
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(542, 418);
            this.Controls.Add(this.btn_admcancelupdatepass);
            this.Controls.Add(this.btn_updatepass);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Name = "Change_Password";
            this.Text = "Admin - Change Password";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private Panel panel1;
        private Label label1;
        private Panel panel2;
        private Label label6;
        private TextBox txt_admrepeatpass;
        private TextBox txt_admnewpass;
        private TextBox txt_admoripass;
        private Label label5;
        private Label label4;
        private Label label3;
        private Label label2;
        private Button btn_updatepass;
        private Button btn_admcancelupdatepass;
        private CheckBox ckbox_admshowpass;
        private Label lbl_admpassnotify;
    }
}