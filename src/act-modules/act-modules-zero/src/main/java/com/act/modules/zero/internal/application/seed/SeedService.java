package com.act.modules.zero.internal.application.seed;

public interface SeedService {
    void  seedData() throws InstantiationException, IllegalAccessException;

    void seedRoleData() throws InstantiationException, IllegalAccessException;
}
