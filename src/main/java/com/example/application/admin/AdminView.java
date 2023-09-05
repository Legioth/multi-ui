package com.example.application.admin;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = AdminLayout.class)
@PageTitle("Main admin view")
public class AdminView extends VerticalLayout {
	public AdminView() {
		add(new Text("This is the admin section"));
	}
}
