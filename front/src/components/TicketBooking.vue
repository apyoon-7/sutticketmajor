<template>
  <v-container class="grey lighten-5">
    <v-row no-gutters align="center" justify="center">
      <v-col cols="9">
        <v-card class="pa-2" outlined tile>
          <h2 class="text-center">Ticket booking</h2>
          <v-select
            v-model="selectedMember"
            :items="members"
            item-text="name"
            item-value="id"
            label="Select your member.WTF?"
            outlined
          ></v-select>
          <v-select
            v-model="selectedShow"
            :items="shows"
            item-text="name"
            item-value="id"
            label="Select interesting shows!"
            outlined
          ></v-select>
          <v-select
            v-model="selectedPerformance"
            :items="performances"
            item-text="name"
            item-value="id"
            label="Select performance time."
            outlined
          ></v-select>
          <v-select
            v-model="selectedSeat"
            :items="seats"
            item-text="id"
            item-value="id"
            label="Select seat."
            outlined
          ></v-select>
          <v-btn @click="checkSubmit">
              Book a Show Ticket
          </v-btn>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import http from "../http-common";
import router from "vue-router";
export default {
  data() {
    return {
      selectedMember: null,
      selectedSeat: null,
      selectedShow: null,
      selectedPerformance: null,
      members: [],
      shows: [],
      seats: [],
      performances: []
    };
  },
  mounted() {
    this.getAllMembers();
    this.getAllShows();
    this.getAllSeats();
    this.getAllPerformances();
  },
  methods: {
      checkSubmit(){
          if(!this.selectedMember || !this.selectedPerformance || !this.selectedSeat || !this.selectedShow){
              alert("Please select all field!");
          }else{
              this.submitTicketBooking();
          }
      },
      submitTicketBooking(){
          http
          .post("/ticketBooking/" + this.selectedMember + "/" + this.selectedShow + "/" + this.selectedPerformance +"/" + this.selectedSeat)
          .then(response => {
              alert("Add data successfully..");
              console.log(JSON.parse(JSON.stringify(response.data)));
              this.$router.push("viewticketbooking");
          })
          .catch(e => {
              console.log(e);
          });
      },
    getAllPerformances() {
      http
        .get("/performances")
        .then(response => {
          this.performances = response.data;
          console.log("Performances data recieve.");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllSeats() {
      http
        .get("/seats")
        .then(response => {
          this.seats = response.data;
          console.log("Seats data recieve.");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllMembers() {
      http
        .get("/members")
        .then(response => {
          this.members = response.data;
          console.log("Members data recieve.");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllShows() {
      http
        .get("/shows")
        .then(response => {
          this.shows = response.data;
          console.log("Shows data receive.");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>