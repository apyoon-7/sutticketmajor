<template>
  <v-container class="grey lighten-5">
    <v-row no-gutters>
      <v-col>
        <v-card class="pa-2" outlined tile>
          <v-data-table
            :headers="headers"
            :items="ticketbookinghistory"
            :items-per-page="5"
            class="elevation-1"
          ></v-data-table>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  data() {
    return {
      headers: [
        {
          text: "TicketBooking ID",
          align: "left",
          sortable: false,
          value: "id"
        },
        { text: "Show Name", value: "show.name" },
        { text: "Performance", value: "performance.name" },
        { text: "Seat", value: "seat.id" },
        { text: "Member", value: "member.name" }
      ],
      ticketbookinghistory: []
    };
  },
  mounted(){
      this.getAllTicketBookings();
  },
  methods: {
      getAllTicketBookings(){
          http
          .get("/ticketBookings")
          .then(response => {
              this.ticketbookinghistory = response.data;
              console.log("Receive ticketbooking :");
              console.log(JSON.parse(JSON.stringify(response.data)));
          })
          .catch(e => {
              console.log(e);
          });
      }
  }
};
</script>