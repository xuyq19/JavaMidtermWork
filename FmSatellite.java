import java.util.Scanner;

/**
 * @author Lucas Xu
 * @version 1.0
 */

class FmSatellite {
    public static void main(String[] args) {
        Satellite sat = new Satellite();
        Authority auth = new Authority();
        auth.view();
    }

    @Override
    public String toString() {
        return "fmSatellite []";
    }
}

class Satellite {
    private String cosparid;
    /**
     * The ID of Satellites.
     */
    private boolean isUsable;
    /**
     * Whether the satellite is usable.
     */
    private double orbitRadius;
    /**
     * The radius of the satellite.
     */
    private String satelliteName;

    /**
     * The name of the satellite.
     */
    public Satellite() {
    }

    public Satellite(String cosparid, boolean isUsable, double orbitRadius, String satelliteName) {
        this.cosparid = cosparid;
        this.isUsable = isUsable;
        this.orbitRadius = orbitRadius;
        this.satelliteName = satelliteName;
    }

    public String getCosparid() {
        return this.cosparid;
    }

    public void setCosparid(String cosparid) {
        this.cosparid = cosparid;
    }

    public boolean getIsUsable() {
        return this.isUsable;
    }

    public void setIsUsable(boolean isUsable) {
        this.isUsable = isUsable;
    }

    public double getOrbitRadius() {
        return this.orbitRadius;
    }

    public void setOrbitRadius(double orbitRadius) {
        this.orbitRadius = orbitRadius;
    }

    public String getSatelliteName() {
        return this.satelliteName;
    }

    public void setSatelliteName(String satelliteName) {
        this.satelliteName = satelliteName;
    }
}

class Authority {
    private Satellite[] satellite = new Satellite[1000];
    int i = 5;

    /**
     * i is the index number of satellites.
     */

    public Authority() {
        satellite[0] = new Satellite("CN0000", true, 1.2, "风云一号");
        satellite[1] = new Satellite("CN0001", true, 1.4, "风云二号");
        satellite[2] = new Satellite("CN0003", true, 1.6, "风云三号");
        satellite[3] = new Satellite("US0001", false, 2.0, "Navstar‑9");
        satellite[4] = new Satellite("US0002", false, 2.2, "KH‑9");
    }

    public void view() {
        Scanner sc = new Scanner(System.in);
        int n;
        /**
         * n is the number of satellites.
         */
        while (true) {
            System.out.println("********************************");
            System.out.println(
                    "1---------显示当前活动卫星列表。\n2---------注册新卫星。\n3---------删除旧卫星。\n4---------激活卫星。\n5---------封锁（失活）卫星。\n6---------显示失活卫星列表。\n7---------按名称模糊查找卫星。\n8---------修改卫星信息。\n9---------退出！\n");
            System.out.println("********************************");
            System.out.println("选择:");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    displaySatellite();
                    /**
                     * Display the information of satellites.
                     */
                    break;
                case 2:
                    addSatellite();
                    /**
                     * Register a new satellite.
                     */
                    break;
                case 3:
                    deleteSatellite();
                    /**
                     * Delete the satellite.
                     */
                    break;
                case 4:
                    activateSatellite();
                    /**
                     * Activate the satellite.
                     */
                    break;
                case 5:
                    blockSatellite();
                    /**
                     * Block the satellite.
                     */
                    break;
                case 6:
                    displayBlockedSatellite();
                    /**
                     * Display the blocked satellite(s).
                     */
                    break;
                case 7:
                    searchSatellite();
                    /**
                     * Search the satellite.
                     */
                    break;
                case 8:
                    changeSatelliteInformation();
                    /**
                     * Change the information of the satellite.
                     */
                    break;
                case 9:
                    System.exit(0);
                /**
                 * Exit.
                 */
                default:
                    System.out.println("输入错误!请重新输入!");
                    /**
                     * User input is illegal.
                     */
            }
        }

    }

    public void displaySatellite() {
        System.out.println("********************************");
        System.out.println("当前活动卫星列表:");
        System.out.println("********************************");
        for (int i = 0; i < this.satellite.length; i++) {
            if (this.satellite[i] != null) {
                System.out.println(this.satellite[i].getCosparid() + " " + this.satellite[i].getSatelliteName() + " "
                        + this.satellite[i].getOrbitRadius() + " " + this.satellite[i].getIsUsable());
            }
        }

    }

    /**
     * Display the information of satellites.
     */
    public void addSatellite() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入卫星名称");
        String satelliteName = sc.next();
        System.out.println("请输入卫星半径");
        double orbitRadius = sc.nextDouble();
        System.out.println("请输入此卫星是否可用(false为否，true为是)");
        Boolean isUsable = sc.nextBoolean();
        if (i < 10) {
            satellite[i] = new Satellite("LZ000" + i, isUsable, orbitRadius, satelliteName);
            System.out.println("添加成功！新添加的卫星信息为" + satellite[i].getCosparid() + " " + satellite[i].getIsUsable() + " "
                    + satellite[i].getOrbitRadius() + " " + satellite[i].getSatelliteName());
            i++;
        } else if (i >= 10 && i < 100) {
            satellite[i] = new Satellite("LZ00" + i, isUsable, orbitRadius, satelliteName);
            System.out.println("添加成功！新添加的卫星信息为" + satellite[i].getCosparid() + " " + satellite[i].getIsUsable() + " "
                    + satellite[i].getOrbitRadius() + " " + satellite[i].getSatelliteName());
            i++;
        } else if (i >= 100 && i < 1000) {
            satellite[i] = new Satellite("LZ0" + i, isUsable, orbitRadius, satelliteName);
            System.out.println("添加成功！新添加的卫星信息为" + satellite[i].getCosparid() + " " + satellite[i].getIsUsable() + " "
                    + satellite[i].getOrbitRadius() + " " + satellite[i].getSatelliteName());
            i++;
        } else if (i >= 1000 && i < 10000) {
            satellite[i] = new Satellite("LZ" + i, isUsable, orbitRadius, satelliteName);
            System.out.println("添加成功！新添加的卫星信息为" + satellite[i].getCosparid() + " " + satellite[i].getIsUsable() + " "
                    + satellite[i].getOrbitRadius() + " " + satellite[i].getSatelliteName());
            i++;
        } else {
            System.out.println("输入错误！");
        }
    }

    /**
     * Register a new satellite.
     */
    public void deleteSatellite() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入卫星名称");
        String satelliteName = sc.next();
        for (int j = 0; j < i; j++) {
            if (satellite[j].getSatelliteName().equals(satelliteName)) {
                satellite[j] = null;
                System.out.println("删除成功！");
                break;
            } else {
                System.out.println("删除失败！");
            }
        }
    }

    /**
     * Delete the satellite.
     */
    public void activateSatellite() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入卫星名称");
        String satelliteName = sc.next();
        for (int j = 0; j < i; j++) {
            if (satellite[j].getSatelliteName().equals(satelliteName)) {
                satellite[j].setIsUsable(true);
                System.out.println("激活成功！");
                break;
            } else {
                System.out.println("激活失败！");
            }
        }
    }

    /**
     * Activate the satellite.
     */
    public void blockSatellite() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入卫星名称");
        String satelliteName = sc.next();
        for (int j = 0; j < i; j++) {
            if (satellite[j].getSatelliteName().equals(satelliteName)) {
                satellite[j].setIsUsable(false);
                System.out.println("锁定成功！");
                break;
            } else {
                System.out.println("锁定失败！");
            }
        }
    }

    /**
     * Block the satellite.
     */
    public void displayBlockedSatellite() {
        for (int j = 0; j < i; j++) {
            if (satellite[j].getIsUsable() == false) {
                System.out.println(satellite[j].getSatelliteName());
            }
        }
    }

    /**
     * Display the blocked satellite(s).
     */
    public void searchSatellite() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入卫星名称");
        String satelliteName = sc.next();
        for (int j = 0; j < i; j++) {
            if (satellite[j].getSatelliteName().equals(satelliteName)) {
                System.out.println(satellite[j].getSatelliteName() + " " + satellite[j].getIsUsable() + " "
                        + satellite[j].getOrbitRadius() + " " + satellite[j].getSatelliteName());
                break;
            } else {
                System.out.println("查询失败！");
            }
        }

    }

    /**
     * Search the satellite.
     */
    public void changeSatelliteInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入卫星名称");
        String satelliteName = sc.next();
        for (int j = 0; j < i; j++) {
            if (satellite[j].getSatelliteName().equals(satelliteName)) {
                System.out.println("请输入卫星名称");
                String newSatelliteName = sc.next();
                System.out.println("请输入卫星是否可用(false为否，true为是)");
                Boolean isUsable = sc.nextBoolean();
                System.out.println("请输入卫星轨道半径");
                double orbitRadius = sc.nextDouble();
                satellite[j].setSatelliteName(newSatelliteName);
                satellite[j].setIsUsable(isUsable);
                satellite[j].setOrbitRadius(orbitRadius);
                System.out.println("修改成功！");
                break;
            } else {
                System.out.println("修改失败！");
            }
        }
    }
    /**
     * Change the information of the satellite.
     */

}