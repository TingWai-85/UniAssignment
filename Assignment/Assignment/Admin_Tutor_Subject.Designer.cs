namespace Assignment
{
    partial class Admin_Tutor_Subject
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
            this.lb_admtutorlvsub = new System.Windows.Forms.ListBox();
            this.btn_admtutoraddsub = new System.Windows.Forms.Button();
            this.btn_admtutordelsub = new System.Windows.Forms.Button();
            this.btn_admtutorsubback = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.Info;
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(-1, -1);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(611, 55);
            this.panel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Viner Hand ITC", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(3, 10);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(245, 32);
            this.label1.TabIndex = 0;
            this.label1.Text = "Excellent Tuition Center";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.SystemColors.Control;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(21, 57);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 28);
            this.label2.TabIndex = 1;
            this.label2.Text = "label2";
            // 
            // lb_admtutorlvsub
            // 
            this.lb_admtutorlvsub.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.lb_admtutorlvsub.FormattingEnabled = true;
            this.lb_admtutorlvsub.ItemHeight = 28;
            this.lb_admtutorlvsub.Location = new System.Drawing.Point(74, 103);
            this.lb_admtutorlvsub.Name = "lb_admtutorlvsub";
            this.lb_admtutorlvsub.Size = new System.Drawing.Size(471, 228);
            this.lb_admtutorlvsub.TabIndex = 2;
            this.lb_admtutorlvsub.SelectedIndexChanged += new System.EventHandler(this.lb_admtutorlvsub_SelectedIndexChanged);
            // 
            // btn_admtutoraddsub
            // 
            this.btn_admtutoraddsub.Location = new System.Drawing.Point(97, 350);
            this.btn_admtutoraddsub.Name = "btn_admtutoraddsub";
            this.btn_admtutoraddsub.Size = new System.Drawing.Size(103, 29);
            this.btn_admtutoraddsub.TabIndex = 3;
            this.btn_admtutoraddsub.Text = "Add Subject";
            this.btn_admtutoraddsub.UseVisualStyleBackColor = true;
            this.btn_admtutoraddsub.Click += new System.EventHandler(this.btn_admtutoraddsub_Click);
            // 
            // btn_admtutordelsub
            // 
            this.btn_admtutordelsub.Enabled = false;
            this.btn_admtutordelsub.Location = new System.Drawing.Point(247, 350);
            this.btn_admtutordelsub.Name = "btn_admtutordelsub";
            this.btn_admtutordelsub.Size = new System.Drawing.Size(116, 29);
            this.btn_admtutordelsub.TabIndex = 4;
            this.btn_admtutordelsub.Text = "Delete Subject";
            this.btn_admtutordelsub.UseVisualStyleBackColor = true;
            this.btn_admtutordelsub.Click += new System.EventHandler(this.btn_admtutordelsub_Click);
            // 
            // btn_admtutorsubback
            // 
            this.btn_admtutorsubback.Location = new System.Drawing.Point(412, 350);
            this.btn_admtutorsubback.Name = "btn_admtutorsubback";
            this.btn_admtutorsubback.Size = new System.Drawing.Size(94, 29);
            this.btn_admtutorsubback.TabIndex = 5;
            this.btn_admtutorsubback.Text = "Back";
            this.btn_admtutorsubback.UseVisualStyleBackColor = true;
            this.btn_admtutorsubback.Click += new System.EventHandler(this.btn_admtutorsubback_Click);
            // 
            // Admin_Tutor_Subject
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(609, 450);
            this.Controls.Add(this.btn_admtutorsubback);
            this.Controls.Add(this.btn_admtutordelsub);
            this.Controls.Add(this.btn_admtutoraddsub);
            this.Controls.Add(this.lb_admtutorlvsub);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.panel1);
            this.Name = "Admin_Tutor_Subject";
            this.Text = "Admin - Tutor -";
            this.Load += new System.EventHandler(this.Admin_Tutor_Subject_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Panel panel1;
        private Label label1;
        private Label label2;
        private ListBox lb_admtutorlvsub;
        private Button btn_admtutoraddsub;
        private Button btn_admtutordelsub;
        private Button btn_admtutorsubback;
    }
}