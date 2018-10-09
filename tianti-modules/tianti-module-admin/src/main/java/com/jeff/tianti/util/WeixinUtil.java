package com.jeff.tianti.util;

import org.springframework.stereotype.Component;

@Component
public class WeixinUtil {

    private String ticket;

    private long ticketTime;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public long getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(long ticketTime) {
        this.ticketTime = ticketTime;
    }
}
