spring:
  freemarker:
    template-loader-path: classpath:/templates/
    prefer-file-system-access: false
<head> 
    <title> Prova Final - JavaScript</title>
    <style>
       .container{
           text-aling: center;
       }

       button{
           background: #069;
           color: white;
           font-size: 32px;
           padding: 8px 20px
           cursor: pointer;
           border: 0;
       }
       </style>
</head>
@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}
<body>
      <audio id="sound" src= "alarme.mp3" style= "display: none;"> </audio>

      <div class="container">
           <h2>Minutos:</h2>
           <select id= "minutos" name="minutos"></select>

           <h2>Segundos:</h2>
           <select id="segundos" name="segundos"></select>
           <br/>
           <br/>
           <button id="comecar">Comecar!</button>
           </div id="display">
                 <h3></h3>
           </div><!--display-->
        </div><!--container-->
spring-cloud-starter-netflix-eureka-server can cause failures on application startup. To remedy this issue, add the Spring Boot Gradle plugin and import the Spring cloud starter parent bom as follows:
build.gradle. 
buildscript {
  dependencies {
    classpath("org.springframework.boot:spring-boot-gradle-plugin:{spring-boot-docs-version}")
  }
}

apply plugin: "spring-boot"

dependencyManagement {
  imports {
    mavenBom "org.springframework.cloud:spring-cloud-dependencies:{spring-cloud-version}"
  }
}
    <script>
      var display= document.getElementById('display');
     
      var minutos= document.getElementById('minutos');
      var segundos= document.getElementById('segundos');

      var comecar = document.getElementById('comecar');
     
      var cronometroSeg;

      var minutoAtual;
      var segundoAtual;

      var interval;

      for(var i = 0; i <= 60; i++){
          minutos.innerHTML+="option value="'+i+'"> '+i+'</option>' ; 
      }
      for(var i= 1; i<= 60; i++){
          segundos.innerHtml+= '<option value" '+i+' ">'+i+'</option>';

      }
server:
  port: 8761

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
       comecar.addEventListener('click', fuction(){
           minutoAtual = minutos.value;
           segundoAtual = segundos.value;

           display.childNodes[1]. innerHTML = minutoAtual + ":"+sefundoAtual;
       
           interval = setInterval (function(){
            
             segundoAtual--;
             if(segundoAtual <= 0){
                 if (minutoAtual > 0){
                     minutoAtual--;
                     segundoAtual = 59;
                 }else{
                     alert("Acabou!");
                     document.getElementById("sound").play();
                     clearInterval(interval);
                 }
                }

            dispaly.childNodes[1].innerHTML = minutoAtual + ";"+segundoAtual;
            },1000);
       
        })
--
spring:
  profiles: peer1
eureka:
  instance:
    hostname: peer1
  client:
    serviceUrl:
      defaultZone: http://peer2/eureka/

---
spring:
  profiles: peer2
eureka:
  instance:
    hostname: peer2
  client:
    serviceUrl:
      defaultZone: http://peer1/eureka/
     
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
} 
    <dependency>
	<groupId>org.glassfish.jaxb</groupId>
	<artifactId>jaxb-runtime</artifactId>
</dependency> 
     
      </script