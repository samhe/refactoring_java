package com.refactor.system_permission;

public class RequestedSate extends AbstractPermissionState {

    public RequestedSate(SystemPermission systemPermission) {
        super(systemPermission);
    }

    @Override
    public void claimBy(SystemAdmin admin) {
        systemPermission.setAdmin(admin);
        systemPermission.setPermissionState(new ClaimedSate(systemPermission));
        systemPermission.notifyAdminOfPermissionRequest();
    }

    @Override
    public void denyBy(SystemAdmin admin) {

    }

    @Override
    public void grantBy(SystemAdmin admin) {

    }

    @Override
    public String getState() {
        return SystemPermission.REQUESTED;
    }
}
