package bomb;

import common.IntList;

public class BombMain {
    public static void answers(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct inputs (passwords) to each phase using debugging techniques
        Bomb b = new Bomb();

        if (phase >= 0) {
            b.phase0("39291226");
            //根据观察得出，phase0的密码类型是String。
            //答案是Bomb.phase0()中的CorrectPassword，由shufflePassword()函数返回。
        }
        if (phase >= 1) {
            b.phase1(new IntList(0,new IntList(9,new IntList(3,new IntList(0,new IntList(8,null)))))); // Figure this out too
            //根据观察得出，phase1的密码类型是IntList。
            //答案是Bomb.phase1()中的correctIntListPassword，由shufflePasswordIntList()函数返回。
            //或者可以定义IntList l=IntList.of(0,9,3,0,8);
            //然后将l传入b.phase1(l);
        }
        if (phase >= 2) {
            b.phase2("-81201430");
            //根据观察得出，phase2的密码类型是String。
            //答案是Bomb.phase2()中的number的数值。
            //其实是将String转换为int类型。
        }
    }
}

