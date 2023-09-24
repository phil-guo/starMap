package com.act.modules.zero.internal.application.seed;

import com.act.core.utils.HttpContextUtils;
import com.act.core.utils.StringExtensions;
import com.act.modules.zero.internal.application.menu.SysMenuService;
import com.act.modules.zero.internal.application.operate.SysOperateService;
import com.act.modules.zero.internal.application.page.PageService;
import com.act.modules.zero.internal.application.pageConfig.PageConfigService;
import com.act.modules.zero.internal.application.role.SysRoleMenuService;
import com.act.modules.zero.internal.application.role.SysRoleService;
import com.act.modules.zero.internal.application.user.SysUserService;
import com.act.modules.zero.internal.domain.*;
import com.alibaba.fastjson.JSON;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@SuppressWarnings("all")
public class SeedServiceImp implements SeedService {

    @Autowired
    private SysUserService _user;

    @Autowired
    private SysRoleService _role;

    @Autowired
    private SysOperateService _operate;

    @Autowired
    private SysMenuService _menu;

    @Autowired
    private SysRoleMenuService _roleMenu;
    @Autowired
    private PageService _page;
    @Autowired
    private PageConfigService _pageConfig;

    @Transactional
    public void seedData() {

        //超级管理员
        seedUserData();

        //角色
        seedRoleData();

        //菜单
        seedMenuData();

        //配置页面
        seedPageData();
    }

    public void seedUserData() {
        var user = new SysUser();
        user.setRoleIds(StringExtensions.UUID_SUPER_ADMIN.toString());
        user.setId(StringExtensions.UUID_SUPER_ADMIN);
        user.setUserName("admin");
        user.setPassword(StringExtensions.ToMd5("123qwe"));
        user.setCreateUser(HttpContextUtils.getUserContext().getName());
        user.setCreateUserId(HttpContextUtils.getUserContext().getUserId());
        _user.save(user);

    }

    public void seedRoleData() {
        var role = new SysRole();

        role.setName("超级管理员");
        role.setId(StringExtensions.UUID_SUPER_ADMIN);

        _role.save(role);
    }

    public HashMap<String, List<String>> seedOperateData() {

        var map = new HashMap<String, List<String>>();
        var operate1 = new SysOperate();
        var id1 = UUID.randomUUID().toString();
        operate1.setId(id1);
        operate1.setName("查询");
        operate1.setUnique(1001);
        operate1.setIsBasicData(true);
        operate1.setCreateUser(HttpContextUtils.getUserContext().getName());
        operate1.setCreateUserId(HttpContextUtils.getUserContext().getUserId());

        var operate2 = new SysOperate();
        var id2 = UUID.randomUUID().toString();
        operate2.setId(id2);
        operate2.setName("添加");
        operate2.setUnique(1002);
        operate2.setIsBasicData(true);
        operate2.setCreateUser(HttpContextUtils.getUserContext().getName());
        operate2.setCreateUserId(HttpContextUtils.getUserContext().getUserId());

        var operate3 = new SysOperate();
        var id3 = UUID.randomUUID().toString();
        operate3.setId(id3);
        operate3.setName("编辑");
        operate3.setUnique(1003);
        operate3.setIsBasicData(true);
        operate3.setCreateUser(HttpContextUtils.getUserContext().getName());
        operate3.setCreateUserId(HttpContextUtils.getUserContext().getUserId());


        var operate4 = new SysOperate();
        var id4 = UUID.randomUUID().toString();
        operate4.setId(id4);
        operate4.setName("删除");
        operate4.setUnique(1004);
        operate4.setIsBasicData(true);
        operate4.setCreateUser(HttpContextUtils.getUserContext().getName());
        operate4.setCreateUserId(HttpContextUtils.getUserContext().getUserId());


        var operate5 = new SysOperate();
        var id5 = UUID.randomUUID().toString();
        operate5.setId(id5);
        operate5.setName("权限");
        operate5.setUnique(1005);
        operate5.setIsBasicData(true);
        operate5.setCreateUser(HttpContextUtils.getUserContext().getName());
        operate5.setCreateUserId(HttpContextUtils.getUserContext().getUserId());


        var operate6 = new SysOperate();
        var id6 = UUID.randomUUID().toString();
        operate6.setId(id6);
        operate6.setName("字段配置");
        operate6.setUnique(1006);
        operate6.setIsBasicData(true);
        operate6.setCreateUser(HttpContextUtils.getUserContext().getName());
        operate6.setCreateUserId(HttpContextUtils.getUserContext().getUserId());

        var operate7 = new SysOperate();
        var id7 = UUID.randomUUID().toString();
        operate7.setId(id7);
        operate7.setName("按钮配置");
        operate7.setUnique(1007);
        operate7.setIsBasicData(true);
        operate7.setCreateUser(HttpContextUtils.getUserContext().getName());
        operate7.setCreateUserId(HttpContextUtils.getUserContext().getUserId());


        var operates = new ArrayList<SysOperate>();
        operates.add(operate1);
        operates.add(operate2);
        operates.add(operate3);
        operates.add(operate4);
        operates.add(operate5);
        operates.add(operate6);
        operates.add(operate7);

        _operate.saveBatch(operates);

        var ids1 = new ArrayList<String>();
        ids1.add(id1);
        ids1.add(id2);
        ids1.add(id3);
        ids1.add(id4);
        ids1.add(id5);
        map.put("1", ids1);
        ids1.add(id6);
        ids1.add(id7);
        map.put("2", ids1);

        return map;
    }

    public void seedMenuData() {
        //添加功能
        var opereateMap = seedOperateData();
        var opereateIds = opereateMap.get("1");
        var opereateIdsOfMenu = opereateMap.get("2");

        var menu1Id = UUID.randomUUID().toString();
        var menu1 = new SysMenu();
        menu1.setName("基础数据");
        menu1.setId(menu1Id);
        menu1.setParentId(StringExtensions.UUID_EMPTY);
        menu1.setCreateUser(HttpContextUtils.getUserContext().getName());
        menu1.setCreateUserId(HttpContextUtils.getUserContext().getUserId());
        menu1.setUrl("/system");
        menu1.setIcon("el-icon-setting");
        menu1.setIsLeftShow(true);
        menu1.setOperates(JSON.toJSONString(new ArrayList<String>()));
        menu1.setLevel(1);
        seedRoleMenu(menu1Id, new ArrayList<String>());

        var menu2Id = UUID.randomUUID().toString();
        var menu2 = new SysMenu();
        menu1.setId(menu2Id);
        menu2.setName("系统菜单");
        menu2.setParentId(menu1Id);
        menu2.setCreateUser(HttpContextUtils.getUserContext().getName());
        menu2.setCreateUserId(HttpContextUtils.getUserContext().getUserId());
        menu2.setUrl("/pages");
        menu2.setIcon("el-icon-suitcase");
        menu2.setIsLeftShow(true);
        menu2.setOperates(JSON.toJSONString(opereateIdsOfMenu));
        menu2.setLevel(2);
        menu2.setKey("sysMenu");
        seedRoleMenu(menu2Id, opereateIdsOfMenu);

        var menu3 = new SysMenu();
        var id3 = UUID.randomUUID().toString();
        menu3.setName("系统角色");
        menu3.setId(id3);
        menu3.setParentId(menu1Id);
        menu3.setCreateUser(HttpContextUtils.getUserContext().getName());
        menu3.setCreateUserId(HttpContextUtils.getUserContext().getUserId());
        menu3.setUrl("/pages");
        menu3.setIcon("el-icon-coordinate");
        menu3.setIsLeftShow(true);
        menu3.setOperates(JSON.toJSONString(opereateIds));
        menu3.setLevel(2);
        menu3.setKey("sysRole");
        seedRoleMenu(id3, opereateIds);

        var menu4 = new SysMenu();
        var id4 = UUID.randomUUID().toString();
        menu4.setId(id4);
        menu4.setName("系统用户");
        menu4.setParentId(menu1Id);
        menu4.setCreateUser(HttpContextUtils.getUserContext().getName());
        menu4.setCreateUserId(HttpContextUtils.getUserContext().getUserId());
        menu4.setUrl("/pages");
        menu4.setIcon("el-icon-user");
        menu4.setIsLeftShow(true);
        menu4.setOperates(JSON.toJSONString(opereateIds));
        menu4.setLevel(2);
        menu4.setKey("sysUser");
        seedRoleMenu(id4, opereateIds);

        var menu5 = new SysMenu();
        var id5 = UUID.randomUUID().toString();
        menu5.setId(id5);
        menu5.setName("功能管理");
        menu5.setParentId(menu1Id);
        menu5.setCreateUser(HttpContextUtils.getUserContext().getName());
        menu5.setCreateUserId(HttpContextUtils.getUserContext().getUserId());
        menu5.setUrl("/pages");
        menu5.setIcon("el-icon-collection-tag");
        menu5.setIsLeftShow(true);
        menu5.setOperates(JSON.toJSONString(opereateIds));
        menu5.setLevel(2);
        menu5.setKey("sysOperate");
        seedRoleMenu(id5, opereateIds);

        var menu6 = new SysMenu();
        var id6 = UUID.randomUUID().toString();
        menu6.setId(id6);
        menu6.setName("数据字典");
        menu6.setParentId(menu1Id);
        menu6.setCreateUser(HttpContextUtils.getUserContext().getName());
        menu6.setCreateUserId(HttpContextUtils.getUserContext().getUserId());
        menu6.setUrl("/pages");
        menu6.setIcon("el-icon-tickets");
        menu6.setIsLeftShow(true);
        menu6.setOperates(JSON.toJSONString(opereateIds));
        menu6.setLevel(2);
        menu6.setKey("sysDictionary");
        seedRoleMenu(id6, opereateIds);

        var menus = new ArrayList<SysMenu>();
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);
        menus.add(menu5);
        menus.add(menu6);
        _menu.saveBatch(menus);
    }

    public void seedPageData() {

        var page1 = new Page();
        var id1 = UUID.randomUUID().toString();
        page1.setId(id1);
        page1.setName("数据字典");
        page1.setKey("sysDictionary");
        seedPageConfig(id1, "/api/v1/sysDataDictionaries/pageSearch");

        var page2 = new Page();
        var id2 = UUID.randomUUID().toString();
        page2.setId(id2);
        page2.setName("功能管理");
        page2.setKey("sysOperate");
        seedPageConfig(id2, "/api/v1/sysOperate/pageSearch");

        var page3 = new Page();
        var id3 = UUID.randomUUID().toString();
        page3.setId(id3);
        page3.setName("系统用户");
        page3.setKey("sysUser");
        seedPageConfig(id3, "/api/v1/sysUsers/pageSearch");

        var page4 = new Page();
        var id4 = UUID.randomUUID().toString();
        page4.setId(id4);
        page4.setName("系统角色");
        page4.setKey("sysRole");
        seedPageConfig(id4, "/api/v1/sysRole/pageSearch");

        var page5 = new Page();
        var id5 = UUID.randomUUID().toString();
        page5.setId(id5);
        page5.setName("系统菜单");
        page5.setKey("sysMenu");
        seedPageConfig(id5, "/api/v1/sysMenus/pageSearch");

        var pages = new ArrayList<Page>();
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);
        pages.add(page4);
        pages.add(page5);

        _page.saveBatch(pages);
    }

    public void seedPageConfig(String pageId, String url) {
        var pageConfig1 = new PageConfig();
        pageConfig1.setPageId(pageId);
        pageConfig1.setDataUrl(url);
        pageConfig1.setIsTableCheckRow(true);
        pageConfig1.setIsTableOperateRow(true);

        _pageConfig.save(pageConfig1);
    }

    public void seedRoleMenu(String menuId, List<String> operates) {

        var roleMenu1 = new SysRoleMenu();
        roleMenu1.setMenuId(menuId);
        roleMenu1.setRoleId(StringExtensions.UUID_SUPER_ADMIN);
        roleMenu1.setOperates(JSON.toJSONString(operates));
        _roleMenu.save(roleMenu1);
    }
}

