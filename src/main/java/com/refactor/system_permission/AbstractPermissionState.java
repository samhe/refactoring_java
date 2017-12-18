package com.refactor.system_permission;

public abstract class AbstractPermissionState implements PermissionState {
    protected SystemPermission systemPermission;

    public AbstractPermissionState(SystemPermission systemPermission) {
        this.systemPermission = systemPermission;
    }
}
