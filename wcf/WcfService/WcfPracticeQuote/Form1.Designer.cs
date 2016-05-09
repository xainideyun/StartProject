namespace WcfPracticeQuote
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.btnGet = new System.Windows.Forms.Button();
            this.lblText = new System.Windows.Forms.Label();
            this.btnGet2 = new System.Windows.Forms.Button();
            this.lblText2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnGet
            // 
            this.btnGet.Location = new System.Drawing.Point(12, 12);
            this.btnGet.Name = "btnGet";
            this.btnGet.Size = new System.Drawing.Size(75, 23);
            this.btnGet.TabIndex = 0;
            this.btnGet.Text = "button1";
            this.btnGet.UseVisualStyleBackColor = true;
            this.btnGet.Click += new System.EventHandler(this.btnGet_Click);
            // 
            // lblText
            // 
            this.lblText.AutoSize = true;
            this.lblText.Location = new System.Drawing.Point(13, 69);
            this.lblText.Name = "lblText";
            this.lblText.Size = new System.Drawing.Size(55, 15);
            this.lblText.TabIndex = 1;
            this.lblText.Text = "label1";
            // 
            // btnGet2
            // 
            this.btnGet2.Location = new System.Drawing.Point(173, 12);
            this.btnGet2.Name = "btnGet2";
            this.btnGet2.Size = new System.Drawing.Size(75, 23);
            this.btnGet2.TabIndex = 2;
            this.btnGet2.Text = "button1";
            this.btnGet2.UseVisualStyleBackColor = true;
            this.btnGet2.Click += new System.EventHandler(this.btnGet2_Click);
            // 
            // lblText2
            // 
            this.lblText2.AutoSize = true;
            this.lblText2.Location = new System.Drawing.Point(170, 69);
            this.lblText2.Name = "lblText2";
            this.lblText2.Size = new System.Drawing.Size(55, 15);
            this.lblText2.TabIndex = 3;
            this.lblText2.Text = "label1";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(806, 697);
            this.Controls.Add(this.lblText2);
            this.Controls.Add(this.btnGet2);
            this.Controls.Add(this.lblText);
            this.Controls.Add(this.btnGet);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnGet;
        private System.Windows.Forms.Label lblText;
        private System.Windows.Forms.Button btnGet2;
        private System.Windows.Forms.Label lblText2;
    }
}

