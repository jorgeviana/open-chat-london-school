# open-chat-london-school
### How the project was bootstrapped

Using [this archtype](https://thepracticaldeveloper.com/archetypes) to create a simple Java 8 application. We also need to set interactive mode to false, otherwise the script will want to talk to you...

Before pushing to Github, the ```open-chat-london-school``` repository has to be created. Visit https://github.com and create the repo!

```
mvn archetype:generate \
-DgroupId=io.github.jorgeviana \
-DartifactId=open-chat-london-school \
\
-DarchetypeGroupId=com.thepracticaldeveloper \
-DarchetypeArtifactId=archetype-java-basic-tpd \
-DarchetypeVersion=1.0.0 \
-DinteractiveMode=false

cd open-chat-london-school

printf "# open-chat-london-school" >> README.md
printf ".idea\n*.iml\ntarget\n" >> .gitignore
git init
git add .
git commit -m "initial commit"
git remote add origin git@github.com:jorgeviana/open-chat-london-school.git
git push -u origin master
```

This is not enough to generate all the boilerplate for the project, we also need some manual steps to include all the dependencies that we are going to need, and we also need some Java code to create and start the web server.

Please have a look at the branch named '1-boilerplate'.