create trigger trigger_BankTrans_insert 
on BankTrans
after insert 
as begin
	-- �ڴ������У���һ����ʱ������ã���inserted�������Ľṹ�����ǲ������ݵı���һ����������д���Ÿող��������
	declare @cardId char(3)
	declare @money money,@cardMoney money
	select @cardId=CardId,@money=TransMoney from inserted
	if(@money<0) 
	begin	-- �û���ȡǮ
			-- ��ѯ�˻�Ǯ��
		select @cardMoney=CardMoney from BankCard where CardId=@cardId
		if((@cardMoney+@money)<0)
		begin -- Ǯ������
			rollback transaction
			raiserror('����',18,1)
			return
		end
	end
	
	-- �û��ڴ�Ǯ����Ǯ��ȡ
	update BankCard set CardMoney=CardMoney+@money where CardId=@cardId
end

