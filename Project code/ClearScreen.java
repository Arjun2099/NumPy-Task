class ClearScreen {
    static void cls() {
        try {
          new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch (Exception E) {
          E.printStackTrace();
        }
      }
}
