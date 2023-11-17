// import com.mongodb.client.*;
// import com.mongodb.client.*;

public class main {
    public static void main(String args[]){
        System.out.println("testee");
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("banco_de_dados");

            // Acesso a uma coleção específica no banco de dados
            MongoCollection<Document> collection = database.getCollection("lista4");

            // Exemplo de inserção de documento na coleção
            Document document = new Document("id", 2222)
                    .append("artigo", "atesteararararara")
                    .append("data", "hojeeee");
            collection.insertOne(document);

            // Exemplo de consulta na coleção
            FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
