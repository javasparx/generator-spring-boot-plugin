var Generator = require('yeoman-generator');
var _ = require('lodash');

module.exports = class extends Generator {

    _method1() {
        this.log('method 1 just ran');
    }

    method2() {
        this.log('method 2 just ran');
    }

    prompting() {
        return this.prompt([
            {
                type: 'input',
                name: 'appname',
                message: 'Give a name for plugin : ',
                default: this.appname, // Default to current folder name
                store: true
            },
            {
                type: 'input',
                name: 'basePackage',
                message: 'What package do you want to use : ',
                default: 'uz.javlon.pbs',
                store: true
            },
            {
                type: 'checkbox',
                name: "deps",
                message: "Add Spring Boot Starters and dependencies to your application",
                choices: [{
                    name: 'Secure your application via spring-security',
                    value: '<dependency>\n' +
                    '\t\t\t<groupId>org.springframework.boot</groupId>\n' +
                    '\t\t\t<artifactId>spring-boot-starter-security</artifactId>\n' +
                    '\t\t</dependency>\n' +
                    '\t\t<dependency>\n' +
                    '\t\t\t<groupId>org.springframework.security</groupId>\n' +
                    '\t\t\t<artifactId>spring-security-test</artifactId>\n' +
                    '\t\t\t<scope>test</scope>\n' +
                    '\t\t</dependency>\n'
                }, {
                    name: 'Full-stack web development with Tomcat and Spring MVC',
                    value: '\t\t<dependency>\n' +
                    '\t\t\t<groupId>org.springframework.boot</groupId>\n' +
                    '\t\t\t<artifactId>spring-boot-starter-web</artifactId>\n' +
                    '\t\t</dependency>\n'
                }, {
                    name: 'Java Persistence API including spring-data-jpa, spring-orm and Hibernate',
                    value: '\t\t<dependency>\n' +
                    '\t\t\t<groupId>org.springframework.boot</groupId>\n' +
                    '\t\t\t<artifactId>spring-boot-starter-data-jpa</artifactId>\n' +
                    '\t\t</dependency>\n'
                }, {
                    name: 'Common spring-integration modules',
                    value: '\t\t<dependency>\n' +
                    '\t\t\t<groupId>org.springframework.boot</groupId>\n' +
                    '\t\t\t<artifactId>spring-boot-starter-integration</artifactId>\n' +
                    '\t\t</dependency>\n'
                }, {
                    name: 'Lombok',
                    value: '\n\t\t<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok-maven -->\n' +
                    '\t\t<dependency>\n' +
                    '\t\t\t<groupId>org.projectlombok</groupId>\n' +
                    '\t\t\t<artifactId>lombok</artifactId>\n' +
                    '\t\t\t<version>1.16.18</version>\n' +
                    '\t\t\t<scope>compile</scope>\n' +
                    '\t\t</dependency>\n'
                }, {
                    name: 'Spring testing',
                    value: '\t\t<dependency>\n' +
                    '\t\t\t<groupId>org.springframework.boot</groupId>\n' +
                    '\t\t\t<artifactId>spring-boot-starter-test</artifactId>\n' +
                    '\t\t\t<scope>test</scope>\n' +
                    '\t\t</dependency>\n'
                }],
                store: true
            },
            // {
            //     type: 'confirm',
            //     name: 'cool',
            //     message: 'Would you like to enable the Cool feature?'
            // },
            // {
            //     type: 'input',
            //     name: 'username',
            //     message: 'What\'s your GitHub username',
            //     store: true
            // }

        ]).then((answers) => {
            // this.appname = answers.appname;
            // this.deps = answers.deps;
            this.options.appname = _.camelCase(_.lowerCase(answers.appname));
            this.options.deps = answers.deps;
            this.options.appnameCapitalized = answers.appname.charAt(0).toUpperCase() + answers.appname.slice(1);
            this.options.appnameKebab = _.kebabCase(answers.appname);
            this.options.basePackage = answers.basePackage + '.' + this.options.appname;
            this.options.packagePath = this.options.basePackage.split('.').join('/');
            this.log('basePackage : ', this.options.basePackage);
            this.log('packagePath : ', this.options.packagePath);
            this.options.lombok = false;
            for (let dep of answers.deps) {
                if (dep.indexOf('projectlombok') !== -1) {
                    this.options.lombok = true;
                }
                if (dep.indexOf('spring-boot-starter-test') !== -1) {
                    this.options.testing = true;
                }
            }
            // this.log('Dependencies : ', answers.deps);
        });
    }

    writing() {
        this.log(this.options);
        this.fs.copyTpl(
            this.templatePath('pom.xml'),
            this.destinationPath('pom.xml'),
            this.options
        );

        this.fs.copyTpl(
            this.templatePath('_gitignore'),
            this.destinationPath('.gitignore'),
            this.options
        );

        this.fs.copyTpl(
            this.templatePath('_gitattributes'),
            this.destinationPath('.gitattributes'),
            this.options
        );

        this.fs.copyTpl(
            this.templatePath('_editorconfig'),
            this.destinationPath('.editorconfig'),
            this.options
        );

        this.fs.copyTpl(
            this.templatePath('./src/main/resources/application.yaml'),
            this.destinationPath('./src/main/resources/application.yaml'),
            this.options
        );

        this.fs.copyTpl(
            this.templatePath('./src/main/java/_config.java'),
            this.destinationPath('./src/main/java/' + this.options.packagePath + '/config/' + this.options.appnameCapitalized + 'Configuration.java'),
            this.options
        );

        this.fs.copyTpl(
            this.templatePath('./src/main/java/_properties.java'),
            this.destinationPath('./src/main/java/' + this.options.packagePath + '/config/' + this.options.appnameCapitalized + 'Properties.java'),
            this.options
        );

        this.fs.copyTpl(
            this.templatePath('./src/main/java/_service.java'),
            this.destinationPath('./src/main/java/' + this.options.packagePath + '/service/' + this.options.appnameCapitalized + 'Service.java'),
            this.options
        );

        this.fs.copyTpl(
            this.templatePath('./src/main/java/_serviceImpl.java'),
            this.destinationPath('./src/main/java/' + this.options.packagePath + '/service/impl/' + this.options.appnameCapitalized + 'ServiceImpl.java'),
            this.options
        );

        if (this.options.testing) {
            this.fs.copyTpl(
                this.templatePath('./src/test/_test.java'),
                this.destinationPath('./src/test/java/' + this.options.packagePath + '/service/impl/' + this.options.appnameCapitalized + 'ServiceImplTest.java'),
                this.options
            );
        }
    }

    end() {
        this.spawnCommandSync('git', ['init']);
        // this.spawnCommandSync('git', ['remote', 'add', 'origin', this.repo]);
        this.spawnCommandSync('git', ['add', '--all']);
        this.spawnCommandSync('git', ['commit', '-m', '"initial commit from generator"']);
        // this.spawnCommandSync('git', ['push', '-u', 'origin', 'master']);
    }

};
