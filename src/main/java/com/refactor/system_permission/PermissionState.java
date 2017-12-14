package com.refactor.system_permission;

public interface PermissionState {
    public void claimBy(SystemAdmin admin);

    void denyBy(SystemAdmin admin);

    void grantBy(SystemAdmin admin);
}
