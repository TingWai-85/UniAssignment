namespace Assignment
{
    partial class Admin_Tutor
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
            this.lb_admtutor = new System.Windows.Forms.ListBox();
            this.btn_admretutor = new System.Windows.Forms.Button();
            this.btn_admsetutor = new System.Windows.Forms.Button();
            this.btn_admdetutor = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.Info;
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(-1, -2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(617, 57);
            this.panel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Viner Hand ITC", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(3, 11);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(245, 32);
            this.label1.TabIndex = 0;
            this.label1.Text = "Excellent Tuition Center";
            // 
            // lb_admtutor
            // 
            this.lb_admtutor.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.lb_admtutor.FormattingEnabled = true;
            this.lb_admtutor.ItemHeight = 28;
            this.lb_admtutor.Location = new System.Drawing.Point(40, 61);
            this.lb_admtutor.Name = "lb_admtutor";
            this.lb_admtutor.Size = new System.Drawing.Size(524, 284);
            this.lb_admtutor.TabIndex = 1;
            this.lb_admtutor.SelectedIndexChanged += new System.EventHandler(this.lb_admtutor_SelectedIndexChanged);
            // 
            // btn_admretutor
            // 
            this.btn_admretutor.Location = new System.Drawing.Point(40, 367);
            this.btn_admretutor.Name = "btn_admretutor";
            this.btn_admretutor.Size = new System.Drawing.Size(124, 29);
            this.btn_admretutor.TabIndex = 2;
            this.btn_admretutor.Text = "Register Tutor";
            this.btn_admretutor.UseVisualStyleBackColor = true;
            this.btn_admretutor.Click += new System.EventHandler(this.btn_admretutor_Click);
            // 
            // btn_admsetutor
            // 
            this.btn_admsetutor.Enabled = false;
            this.btn_admsetutor.Location = new System.Drawing.Point(186, 367);
            this.btn_admsetutor.Name = "btn_admsetutor";
            this.btn_admsetutor.Size = new System.Drawing.Size(116, 29);
            this.btn_admsetutor.TabIndex = 3;
            this.btn_admsetutor.Text = "Select Tutor";
            this.btn_admsetutor.UseVisualStyleBackColor = true;
            this.btn_admsetutor.Click += new System.EventHandler(this.btn_admsetutor_Click);
            // 
            // btn_admdetutor
            // 
            this.btn_admdetutor.Enabled = false;
            this.btn_admdetutor.Location = new System.Drawing.Point(320, 367);
            this.btn_admdetutor.Name = "btn_admdetutor";
            this.btn_admdetutor.Size = new System.Drawing.Size(112, 29);
            this.btn_admdetutor.TabIndex = 4;
            this.btn_admdetutor.Text = "Delete Tutor";
            this.btn_admdetutor.UseVisualStyleBackColor = true;
            this.btn_admdetutor.Click += new System.EventHandler(this.btn_admdetutor_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(470, 367);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(94, 29);
            this.button1.TabIndex = 5;
            this.button1.Text = "back";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Admin_Tutor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(617, 433);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btn_admdetutor);
            this.Controls.Add(this.btn_admsetutor);
            this.Controls.Add(this.btn_admretutor);
            this.Controls.Add(this.lb_admtutor);
            this.Controls.Add(this.panel1);
            this.Name = "Admin_Tutor";
            this.Text = "Admin - Tutor";
            this.Load += new System.EventHandler(this.Admin_Tutor_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private Panel panel1;
        private Label label1;
        private ListBox lb_admtutor;
        private Button btn_admretutor;
        private Button btn_admsetutor;
        private Button btn_admdetutor;
        private Button button1;
    }
}