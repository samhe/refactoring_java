package com.refactor.system_permission;

public interface PermissionState {
    public void claimBy(SystemAdmin admin);

    public void denyBy(SystemAdmin admin);

    public void grantBy(SystemAdmin admin);
}
