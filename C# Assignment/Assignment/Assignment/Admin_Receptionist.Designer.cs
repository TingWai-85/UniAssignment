namespace Assignment
{
    partial class Admin_Receptionist
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
            this.lb_admrecep = new System.Windows.Forms.ListBox();
            this.btn_admrerecep = new System.Windows.Forms.Button();
            this.btn_admderecep = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.Info;
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(-3, -2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(622, 61);
            this.panel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Viner Hand ITC", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(0, 11);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(245, 32);
            this.label1.TabIndex = 0;
            this.label1.Text = "Excellent Tuition Center";
            // 
            // lb_admrecep
            // 
            this.lb_admrecep.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.lb_admrecep.FormattingEnabled = true;
            this.lb_admrecep.ItemHeight = 28;
            this.lb_admrecep.Location = new System.Drawing.Point(58, 65);
            this.lb_admrecep.Name = "lb_admrecep";
            this.lb_admrecep.Size = new System.Drawing.Size(499, 228);
            this.lb_admrecep.TabIndex = 1;
            this.lb_admrecep.SelectedIndexChanged += new System.EventHandler(this.lb_admrecep_SelectedIndexChanged);
            // 
            // btn_admrerecep
            // 
            this.btn_admrerecep.Location = new System.Drawing.Point(58, 306);
            this.btn_admrerecep.Name = "btn_admrerecep";
            this.btn_admrerecep.Size = new System.Drawing.Size(163, 29);
            this.btn_admrerecep.TabIndex = 2;
            this.btn_admrerecep.Text = "Register Receptionist";
            this.btn_admrerecep.UseVisualStyleBackColor = true;
            this.btn_admrerecep.Click += new System.EventHandler(this.btn_admrerecep_Click);
            // 
            // btn_admderecep
            // 
            this.btn_admderecep.Enabled = false;
            this.btn_admderecep.Location = new System.Drawing.Point(243, 306);
            this.btn_admderecep.Name = "btn_admderecep";
            this.btn_admderecep.Size = new System.Drawing.Size(157, 29);
            this.btn_admderecep.TabIndex = 3;
            this.btn_admderecep.Text = "Delete Receptionist";
            this.btn_admderecep.UseVisualStyleBackColor = true;
            this.btn_admderecep.Click += new System.EventHandler(this.btn_admderecep_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(426, 306);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(131, 29);
            this.button1.TabIndex = 4;
            this.button1.Text = "back";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Admin_Receptionist
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(619, 368);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btn_admderecep);
            this.Controls.Add(this.btn_admrerecep);
            this.Controls.Add(this.lb_admrecep);
            this.Controls.Add(this.panel1);
            this.Name = "Admin_Receptionist";
            this.Text = "Admin - Receptionist";
            this.Load += new System.EventHandler(this.Admin_Receptionist_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private Panel panel1;
        private Label label1;
        private ListBox lb_admrecep;
        private Button btn_admrerecep;
        private Button btn_admderecep;
        private Button button1;
    }
}