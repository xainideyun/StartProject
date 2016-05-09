<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WcfFirst.aspx.cs" Inherits="WcfPractice.WcfFirst" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Button ID="btnSubmit" runat="server" Text="确定" OnClick="btnSubmit_Click" />
        <asp:Label ID="lblName" runat="server"></asp:Label>
    </div>
    </form>
</body>
</html>
