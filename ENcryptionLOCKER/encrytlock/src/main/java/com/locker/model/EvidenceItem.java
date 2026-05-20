package com.locker.model;
import java.time.LocalDateTime;

public class EvidenceItem {
    private String whoFiledID;
    private String IDnumber;
    private String filePath;
    private byte[] encrytedDataByteBUffer;
    private boolean confirmed;
    private LocalDateTime createdAtTime;
    private LocalDateTime expiresAt;

    public EvidenceItem(String whoseID, String identifyiingNumber, String path, byte[] hiddenData, boolean confirmation, 
        LocalDateTime madeAt, LocalDateTime endsAt)
    {
        this.whoFiledID = whoseID;
        this.IDnumber = identifyiingNumber;
        this.filePath = path;
        this.encrytedDataByteBUffer = hiddenData;
        this.confirmed = confirmation;
        this.createdAtTime = madeAt;
        this.expiresAt = endsAt;
    }
    public String getEmpolyeeIDNumbver(){
        return whoFiledID;
    }
    public String getID(){
        return IDnumber;
    }
    public String getFilePath(){
        return filePath;
    }
    public byte[] hiddenData(){
        return encrytedDataByteBUffer;
    }
    public boolean confirmation(){
        return confirmed;
    }
    public LocalDateTime madeAt(LocalDateTime timeOFFilingEncrpytionNowDateTime){
        return createdAtTime;
    }
    public LocalDateTime endsAt(LocalDateTime timeOfEndedFIlingNow){
        return expiresAt;
    }

}
