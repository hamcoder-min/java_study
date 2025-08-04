package chapter21_mini_project_exercise.service;

import chapter21_mini_project_exercise.model.MemberVo;

public interface BookMarketService {
	MemberVo customerInfo();
	void menuGuestInfo();
	void menuCartItemList();
	void menuCartClear();
	void menuCartAddItem();
	void menuCartRemoveItemCount();
	void menuCartRemoveItem();
	void menuCartBill();
	void menuExit();
}
