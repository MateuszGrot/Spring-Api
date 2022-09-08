package pl.mateuszgrot.workoutapp;

import java.util.UUID;

public class UuidWrapper {

  public UUID id;

  static String toString(UUID id){
    return id.toString();
  }

  static UUID fromString(String id){
    return UUID.fromString(id);
  }

  static UUID getUuid(){
    return UUID.randomUUID();
  }

}
