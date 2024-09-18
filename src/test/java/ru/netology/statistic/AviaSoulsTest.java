package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Сургут", 12_500, 18, 21);
    Ticket ticket2 = new Ticket("Москва", "Сургут", 10_700, 9, 11);
    Ticket ticket3 = new Ticket("Москва", "Сургут", 9_900, 10, 11);
    Ticket ticket4 = new Ticket("Москва", "Сургут", 8_500, 15, 20);
    Ticket ticket5 = new Ticket("Москва", "Сургут", 6_500, 4, 8);
    Ticket ticket6 = new Ticket("Москва", "Сургут", 7_500, 7, 11);
    AviaSouls avia = new AviaSouls();

    @Test
    public void addAllTickets() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = avia.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFourTicket() {

        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] expected = {ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = avia.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addOneTicket() {

        avia.add(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = avia.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void doNotAddTickets() {

        Ticket[] expected = {};
        Ticket[] actual = avia.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketsByDepartureAndArrivalAirports_1() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] expected = {ticket5, ticket6, ticket4, ticket3, ticket2, ticket1};
        Ticket[] actual = avia.search("Москва", "Сургут");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketsByDepartureAndArrivalAirports_2() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = avia.search("Ржев", "Сургут");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortComparator() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        TicketTimeComparator ticketTime = new TicketTimeComparator();

        Arrays.sort(avia.findAll(), ticketTime);

        Ticket[] expected = {ticket3, ticket2, ticket1, ticket5, ticket6, ticket4};
        Ticket[] actual = avia.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketsByflighttime_1() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        TicketTimeComparator ticketTime = new TicketTimeComparator();


        Ticket[] expected = {ticket3, ticket2, ticket1, ticket5, ticket6, ticket4};
        Ticket[] actual = avia.searchAndSortBy("Москва", "Сургут", ticketTime);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketsByflighttime_2() {


        TicketTimeComparator ticketTime = new TicketTimeComparator();


        Ticket[] expected = {};
        Ticket[] actual = avia.searchAndSortBy("Москва", "Сургут", ticketTime);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketsByflighttime_3() {
        avia.add(ticket5);
        avia.add(ticket6);

        TicketTimeComparator ticketTime = new TicketTimeComparator();


        Ticket[] expected = {ticket5, ticket6};
        Ticket[] actual = avia.searchAndSortBy("Москва", "Сургут", ticketTime);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void writeDownTheHashCode() {

        int expected = Objects.hash("Москва", "Сургут", 12_500, 18, 21);
        int actual = ticket1.hashCode();
        Assertions.assertEquals(expected, actual);
    }
}