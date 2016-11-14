create trigger trigger_BankTrans_insert 
on BankTrans
after insert 
as begin
	-- 在触发器中，有一张临时表可以用，叫inserted表，这个表的结构和我们插入数据的表结果一样，这个表中存放着刚刚插入的数据
	declare @cardId char(3)
	declare @money money,@cardMoney money
	select @cardId=CardId,@money=TransMoney from inserted
	if(@money<0) 
	begin	-- 用户在取钱
			-- 查询账户钱数
		select @cardMoney=CardMoney from BankCard where CardId=@cardId
		if((@cardMoney+@money)<0)
		begin -- 钱数不够
			rollback transaction
			raiserror('余额不足',18,1)
			return
		end
	end
	
	-- 用户在存钱或者钱够取
	update BankCard set CardMoney=CardMoney+@money where CardId=@cardId
end

