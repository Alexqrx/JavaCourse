package com.tgt.common.learn;

import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer implements MediaPlayer{
    private CompactDisc cd;

    @Autowired(required = false)
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
