package com.example.application.admin;

import java.util.List;

import org.vaadin.lineawesome.LineAwesomeIcon;

import com.example.application.views.helloworld.HelloWorldView;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RoutePrefix;
import com.vaadin.flow.theme.lumo.LumoUtility;

@RoutePrefix("admin")
public class AdminLayout extends AppLayout {

	private H2 viewTitle;

	public AdminLayout() {
		setPrimarySection(Section.DRAWER);
		addDrawerContent();
		addHeaderContent();
		addClassName("admin");
	}

	private void addHeaderContent() {
		DrawerToggle toggle = new DrawerToggle();
		toggle.setAriaLabel("Menu toggle");

		viewTitle = new H2();
		viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

		addToNavbar(true, toggle, viewTitle);
	}

	private void addDrawerContent() {
		H1 appName = new H1("Multi UI - Admin");
		appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
		Header header = new Header(appName);

		Scroller scroller = new Scroller(createNavigation());

		addToDrawer(header, scroller, createFooter());
	}

	private SideNav createNavigation() {
		SideNav nav = new SideNav();

		nav.addItem(new SideNavItem("Admin", AdminView.class, LineAwesomeIcon.WRENCH_SOLID.create()));
		nav.addItem(new SideNavItem("Back to safety", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));

		return nav;
	}

	private Footer createFooter() {
		Footer layout = new Footer();

		return layout;
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		viewTitle.setText(getCurrentPageTitle());
	}

	private String getCurrentPageTitle() {
		PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
		return title == null ? "" : "Admin - " + title.value();
	}

	public static AdminLayout getCurrent() {
		// Use this instead of UI.getCurrent() if you want to access state that is
		// stored in this class
		List<HasElement> chain = UI.getCurrent().getInternals().getActiveRouterTargetsChain();
		if (chain.isEmpty()) {
			return null;
		}
		HasElement last = chain.get(chain.size() - 1);
		if (last instanceof AdminLayout layout) {
			return layout;
		} else {
			return null;
		}
	}
}
