package com.aleshamaray.terraform_associate_mcq;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.aleshamaray.terraform_associate_mcq.Constants.Constants;

// TODO: Use a database for this info
@Data
public class InitQuestions {

  private List<Question> questions;

  public InitQuestions() {

    questions = new ArrayList<>();

    String q1 = "The terraform.tfstate file always matches your currently built infrastructure";
    String q1Options = "\tT. True\n\tF. False";
    String q1Explanation = """
        Explanation: The terraform.tfstate file can be updated and the infrastructure will be updated based on the update
        Reference: https://developer.hashicorp.com/terraform/language/state """;
    questions.add(new Question(Constants.TRUE_FALSE, q1, q1Options, "F", q1Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q2 = "One remote backend configuration always maps to a single remote workspace";
    String q2Options = "\tT. True\n\tF. False";
    String q2Explanation = """
        Explanation: The remote backend can work with either a single remote Terraform Cloud workspace or with multiple similarly-named remote workspaces
        Reference: https://developer.hashicorp.com/terraform/language/settings/backends/remote """;
    questions.add(new Question(Constants.TRUE_FALSE, q2, q2Options, "F", q2Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q3 = "How is the Terraform remote backend different from other state backends such as S3, Consul, Etc";
    String q3Options = """
        \tA. It can execute Terraform run on dedicated infrastructure on-prem or in Terraform Cloud
        \tB. It doesn't show the output of a `terraform apply` locally
        \tC. It is only available to paying customers
        \tD. All of the above""";
    String q3Explanation = " Reference: https://www.terraform.io/docs/language/settings/backends/index ";
    questions.add(new Question(Constants.MULTI_CHOICE, q3, q3Options, "A", q3Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q4 = "What is the workflow for deploying new infrastructure with Terraform?";
    String q4Options = """
        \tA. A `terraform plan` to import the current infrastructure to the state file, make code changes, and `terraform apply` to update the infrastructure
        \tB. Write a Terraform configuration, run `terraform show` to view proposed changes, and `terraform apply` to create new infrastructure.
        \tC. `terraform import` to import the current infrastructure to the state file, make code changes, and `terraform apply` to update the infrastructure
        \tD. Write a Terraform configuration, run `terraform init`, run `terraform plan` to view planned infrastructure changes, and `terraform apply` to create new infrastructure""";
    String q4Explanation = " Reference: https://developer.hashicorp.com/terraform/intro/core-workflow ";
    questions.add(new Question(Constants.MULTI_CHOICE, q4, q4Options, "D", q4Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q5 = """
        A provider configuration block is required in every Terraform configuration.
        Example:
          provider "provider_name" {
            ...
          }""";
    String q5Options = "\tT. True\n\tF. False";
    String q5Explanation = "Reference: https://developer.hashicorp.com/terraform/language/providers/configuration ";
    questions.add(new Question(Constants.TRUE_FALSE, q5, q5Options, "T", q5Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q6 = """
        You run a local-exec provisioner in a null resource called null_resource.run_script and realize that you need to rerun the script.
        Which of the following commands would you use first?""";
    String q6Options = """
        \tA. A `terraform plan` to import the current infrastructure to the state file, make code changes, and `terraform apply` to update the infrastructure
        \tB. Write a Terraform configuration, run `terraform show` to view proposed changes, and `terraform apply` to create new infrastructure.
        \tC. `terraform import` to import the current infrastructure to the state file, make code changes, and `terraform apply` to update the infrastructure
        \tD. Write a Terraform configuration, run `terraform init`, run `terraform plan` to view planned infrastructure changes, and `terraform apply` to create new infrastructure""";
    String q6Explanation = " Reference: https://developer.hashicorp.com/terraform/language/resources/provisioners/local-exec ";
    questions.add(new Question(Constants.MULTI_CHOICE, q6, q6Options, "A", q6Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q7 = "Which provisioner invokes a process on the resource created by Terraform?";
    String q7Options = """
        \tA. remote-exec
        \tB. null-exec
        \tC. local-exec
        \tD. file""";
    String q7Explanation = " Reference: https://developer.hashicorp.com/terraform/language/resources/provisioners/remote-exec ";
    questions.add(new Question(Constants.MULTI_CHOICE, q7, q7Options, "A", q7Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q8 = "Which of the following is not true of Terraform providers?";
    String q8Options = """
        \tA. Providers can be written by individuals
        \tB. Providers can be maintained by a community of users
        \tC. Some providers are maintained by HashiCorp
        \tD. Major cloud vendors and non-cloud vendors can write, maintain, or collaborate on Terraform providers
        \tE. None of the above""";
    String q8Explanation = " Reference: https://jayendrapatil.com/terraform-cheat-sheet/#Terraform_Read_and_write_configuration ";
    questions.add(new Question(Constants.MULTI_CHOICE, q8, q8Options, "D", q8Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q9 = "What command does Terraform require the first time you run it within a configuration directory?";
    String q9Options = """
        \tA. terraform import
        \tB. terraform init
        \tC. terraform plan
        \tD. terraform workspace""";
    String q9Explanation = " Reference: https://www.terraform.io/docs/cli/commands/init ";
    questions.add(new Question(Constants.MULTI_CHOICE, q9, q9Options, "B", q9Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q10 = """
        You have deployed a new webapp with a public IP address on a cloud provider. However, you did not create any outputs for your code.
        What is the best method to quickly find the IP address of the resource you deployed?""";
    String q10Options = """
        \tA. Run `terraform output ip_address` to view the result
        \tB. In a new folder, use the terraform_remote_state data source to load in the state file, then write an output for each resource that you find the state file
        \tC. Run `terraform state list` to find the name of the resource, then `terraform state show` to find the attributes including public IP address
        \tD. Run `terraform destroy` then `terraform apply` and look for the IP address in stdout""";
    String q10Explanation = " Reference: https://developer.hashicorp.com/terraform/language/state ";
    questions.add(new Question(Constants.MULTI_CHOICE, q10, q10Options, "C", q10Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q11 = "Which of the following is not a key principle of Infrastructure as Code (IaC)";
    String q11Options = """
        \tA. Versioned Infrastructure
        \tB. Golden Images
        \tC. Idempotence
        \tD. Self-describing infrastructure""";
    String q11Explanation = " Reference: https://www.hashicorp.com/resources/what-is-infrastructure-as-code ";
    questions.add(new Question(Constants.MULTI_CHOICE, q11, q11Options, "B", q11Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q12 = "Terraform variables and outputs that set the \"description\" argument will store that description in the state file";
    String q12Options = "\tT. True\n\tF. False";
    String q12Explanation = " Reference: https://developer.hashicorp.com/terraform/language/values/variables#input-variable-documentation ";
    questions.add(new Question(Constants.TRUE_FALSE, q12, q12Options, "F", q12Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q13 = """
        What is the provider for this fictitious resource?
          resource "aws_vpc" "main" {
            name = "test"
          }""";
    String q13Options = """
        \tA. vpc
        \tB. main
        \tC. aws
        \tD. test""";
    String q13Explanation = " Reference: https://docs.aws.amazon.com/cloudformation-cli/latest/userguide/resource-types ";
    questions.add(new Question(Constants.MULTI_CHOICE, q13, q13Options, "C", q13Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q14 = "If you manually destroy infrastructure, what is the best practice reflecting this change in Terraform";
    String q14Options = """
        \tA. Run `terraform refresh`
        \tB. It will happen automatically
        \tC. Manually update the state file
        \tD. Run `terraform import`""";
    String q14Explanation = " Reference: https://developer.hashicorp.com/terraform/cli/commands/refresh ";
    questions.add(new Question(Constants.MULTI_CHOICE, q14, q14Options, "A", q14Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q15 = "What is not processed when running a terraform refresh?";
    String q15Options = """
        \tA. State file
        \tB. Configuration file
        \tC. Credentials
        \tD. Cloud provider""";
    String q15Explanation = " Reference: https://developer.hashicorp.com/terraform/cli/commands/refresh ";
    questions.add(new Question(Constants.MULTI_CHOICE, q15, q15Options, "B", q15Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q16 = "What information does the public Terraform Module Registry automatically expose about published modules? ";
    String q16Options = """
        \tA. Required input variables
        \tB. Optional inputs variables and default values
        \tC. Outputs
        \tD. All of the above
        \tE. None of the above""";
    String q16Explanation = " Reference: https://www.terraform.io/registry/modules/publish ";
    questions.add(new Question(Constants.MULTI_CHOICE, q16, q16Options, "D", q16Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q17 = "If a module uses local values, you can expose that value with a `terraform output`";
    String q17Options = "\tT. True\n\tF. False";
    String q17Explanation = """
        Reference: https://www.terraform.io/docs/language/values/local
        Reference: https://www.terraform.io/docs/language/values/outputs """;
    questions.add(new Question(Constants.TRUE_FALSE, q17, q17Options, "T", q17Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q18 = "You should store secret data in the same version control repository as your Terraform configuration";
    String q18Options = "\tT. True\n\tF. False";
    String q18Explanation = " Reference: https://blog.gruntwork.io/a-comprehensive-guide-to-managing-secrets-in-your-terraform-code-1d586955ace1 ";
    questions.add(new Question(Constants.TRUE_FALSE, q18, q18Options, "F", q18Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q19 = "Which of the following is not a valid string function in Terraform";
    String q19Options = """
        \tA. split
        \tB. join
        \tC. slice
        \tD. chomp""";
    String q19Explanation = """
        While slice is a valid Terraform string function, it is not from the original list of functions.
        Reference: https://developer.hashicorp.com/terraform/language/functions/slice """;
    questions.add(new Question(Constants.MULTI_CHOICE, q19, q19Options, "C", q19Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q20 = """
        You have provisioned some virtual machines (VMs) on Google Cloud Platform (GCP) using the gcloud command line tool.
        However you are standardizing with Terraform and want to manage these VMs using Terraform instead.
        What are the two things you must do to achieve this? [Choose Two]""";
    String q20Options = """
        \tA. Provision new VMs using Terraform with the same VM names
        \tB. Use the `terraform import` command for the existing VMs
        \tC. Write Terraform configuration for the existing VMs
        \tD. Run the `terraform import-gcp` command""";
    String q20Explanation = " Reference: https://www.terraform.io/docs/cli/import/usage ";
    questions.add(new Question(Constants.MULTI_ANSWER, q20, q20Options, "BC", q20Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q21 = """
        You have recently started a new job at a retailer as an engineer. As part of this new role, you have been tasked
        with evaluating multiple outages that occurred during peak shopping time during the holiday season. Your
        investigation found that the team is manually deploying new compute instances and configuring each compute instance.
        How would you solve this using IaC?""";
    String q21Options = """
        \tA. Implement a ticketing workflow that makes engineers submit a ticket before manually provisioning and configuring a resource
        \tB. Implement a checklist that engineers can follow when configuring compute instances
        \tC. Replace the compute instance type with a larger version to reduce the number of required deployments
        \tD. Implement a provisioning pipeline that deploys infrastructure configurations committed to your version control system following code reviews""";
    String q21Explanation = "";
    questions.add(new Question(Constants.MULTI_CHOICE, q21, q21Options, "D", q21Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q22 = "`terraform init` initializes a sample main.tf file in the current directory";
    String q22Options = "\tT. True\n\tF. False";
    String q22Explanation = " Reference: https://developer.hashicorp.com/terraform/cli/commands/init ";
    questions.add(new Question(Constants.TRUE_FALSE, q22, q22Options, "F", q22Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q23 = "Which two steps are required to provision new infrastructure in the Terraform workflow? [Choose Two]";
    String q23Options = """
        \tA. Destroy
        \tB. Apply
        \tC. Import
        \tD. Init
        \tE. Validate""";
    String q23Explanation = " Reference: https://www.terraform.io/guides/core-workflow ";
    questions.add(new Question(Constants.MULTI_ANSWER, q23, q23Options, "BD", q23Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q24 = "Why would you use the `terraform taint` command?";
    String q24Options = """
        \tA. When you want to force Terraform to destroy a resource on the next apply
        \tB. When you want to force Terraform to destroy and recreate a resource on the next apply
        \tC. When you want Terraform to ignore a resource on the next apply
        \tD. When you want Terraform to destroy all the infrastructure in your workspace""";
    String q24Explanation = " Reference: https://www.terraform.io/docs/cli/commands/taint ";
    questions.add(new Question(Constants.MULTI_CHOICE, q24, q24Options, "B", q24Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q25 = "Terraform requires the Go runtime as a prerequisite for installation";
    String q25Options = "\tT. True\n\tF. False";
    String q25Explanation = " Reference: https://www.terraform.io/docs/extend/guides/v1-upgrade-guide ";
    questions.add(new Question(Constants.TRUE_FALSE, q25, q25Options, "F", q25Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q26 = "When should you use the force-unlock command?";
    String q26Options = """
        \tA. You see a status message that you cannot acquire the lock
        \tB. You have a high priority change
        \tC. Automatic unlocking failed
        \tD. Your apply failed due to a state lock""";
    String q26Explanation = " Reference: https://www.terraform.io/docs/cli/commands/force-unlock ";
    questions.add(new Question(Constants.MULTI_CHOICE, q26, q26Options, "C", q26Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q27 = "Terraform can import modules from a number of sources. Which of the following is not a valid source?";
    String q27Options = """
        \tA. FTP server
        \tB. GitHub repository
        \tC. Local Path
        \tD. Terraform Module Registry""";
    String q27Explanation = " Reference: https://developer.hashicorp.com/terraform/language/modules/sources ";
    questions.add(new Question(Constants.MULTI_CHOICE, q27, q27Options, "A", q27Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q28 = "Which of the following is available only in Terraform Enterprise or Cloud workspace and not in Terraform CLI?";
    String q28Options = """
        \tA. Secure variable storage
        \tB. Support for multiple cloud providers
        \tC. Dry runs with terraform plan
        \tD. Using the workspace as a data source""";
    String q28Explanation = " Reference: https://developer.hashicorp.com/terraform/cloud-docs ";
    questions.add(new Question(Constants.MULTI_CHOICE, q28, q28Options, "A", q28Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q29 = "`terraform validate` validates the syntax of Terraform files.";
    String q29Options = "\tT. True\n\tF. False";
    String q29Explanation = " Reference: https://developer.hashicorp.com/terraform/cli/commands/validate ";
    questions.add(new Question(Constants.TRUE_FALSE, q29, q29Options, "T", q29Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q30 = """
        You have used Terraform to create an ephemeral development environment in the cloud and are now ready to destroy all of the infrastructure described by your Terraform configuration.
        To be safe, you would like to first see all the infrastructure that will be deleted by Terraform.
        Which command should you use to show all of the resources that will be deleted? [Choose Two]""";
    String q30Options = """
        \tA. Run `terraform plan -destroy`
        \tB. This is not possible. You can only show resources that will be created
        \tC. Run `terraform state rm *`
        \tD. Run terraform destroy and it will first output all the resources that will be deleted before prompting for approval""";
    String q30Explanation = " Reference: https://developer.hashicorp.com/terraform/cli/commands/destroy ";
    questions.add(new Question(Constants.MULTI_ANSWER, q30, q30Options, "AD", q30Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q31 = "Which of the following is the correct way to pass the value num_servers into a module with the input servers?";
    String q31Options = """
        \tA. servers = num_servers
        \tB. servers = variable.num_servers
        \tC. servers = var(num_servers)
        \tD. servers = var.num_servers""";
    String q31Explanation = " Reference: https://developer.hashicorp.com/terraform/language/values/variables ";
    questions.add(new Question(Constants.MULTI_CHOICE, q31, q31Options, "A", q31Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q32 = "A Terraform provisioner must be nested inside of a resource configuration block.";
    String q32Options = "\tT. True\n\tF. False";
    String q32Explanation = " Reference: https://www.terraform.io/docs/language/resources/provisioners/connection ";
    questions.add(new Question(Constants.TRUE_FALSE, q32, q32Options, "T", q32Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q33 = "Terraform can run on Windows or Linux, but it requires a Server version of the Windows operating system";
    String q33Options = "\tT. True\n\tF. False";
    String q33Explanation = " Reference: https://learn.hashicorp.com/tutorials/terraform/install-cli ";
    questions.add(new Question(Constants.TRUE_FALSE, q33, q33Options, "T", q33Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q34 = "What does the default \"local\" Terraform backend store?";
    String q34Options = """
        \tA. tfplan files
        \tB. Terraform binary
        \tC. Provider plugins
        \tD. State file""";
    String q34Explanation = " Reference: https://www.terraform.io/docs/language/settings/backends/local ";
    questions.add(new Question(Constants.MULTI_CHOICE, q34, q34Options, "D", q34Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q35 = """
        You have multiple team members collaborating on Infrastructure as Code (IaC) using Terraform and want to apply formatting standards for readability.
        How can you format Terraform HashiCorp Configuration Language (HCL) according to standard Terraform style convention? """;
    String q35Options = """
        \tA. Run the `terraform fmt` command during the code linting phase of your CI/CD process
        \tB. Designate one person in each team to review and format everyone's code
        \tC. Manually apply two spaces indentation and align equal sign \" = \" characters in every Terraform file (*.tf)
        \tD. Write a shell script to transfer Terraform files using tools such as awk, Python, and sed """;
    String q35Explanation = " Reference: https://www.terraform.io/docs/language/syntax/style ";
    questions.add(new Question(Constants.MULTI_CHOICE, q35, q35Options, "A", q35Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q36 = """
      What value does the Terraform Cloud/Terraform Enterprise private module registry provide over the public Terraform Module Registry? """;
    String q36Options = """
      \tA. The ability to share modules with public Terraform users and members of Terraform Enterprise Organizations
      \tB. The ability to tag modules by version or release
      \tC. The ability to restrict modules to Terraform Cloud or Enterprise Organizations
      \tD. The ability to share modules publicly with any user of Terraform """;
    String q36Explanation = " Reference: https://www.terraform.io/docs/language/modules/sources ";
    questions.add(new Question(Constants.MULTI_CHOICE, q36, q36Options, "C", q36Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q37 = """
      Which task does `terraform init` not perform? """;
    String q37Options = """
      \tA. Sources all providers present in the configuration and ensures they are downloaded and available locally
      \tB. Connects to the backend
      \tC. Sources any modules and copies the configuration locally
      \tD. Validates all required variables are present """;
    String q37Explanation = " Reference: https://www.terraform.io/docs/cli/commands/init ";
    questions.add(new Question(Constants.MULTI_CHOICE, q37, q37Options, "D", q37Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q38 = """
      You have declared a variable called var.list which is a list of objects that all have an attribute id.
      Which options will produce a list of the IDs? [Choose Two] """;
    String q38Options = """
      \tA. { for o in var.list : o => o.id }
      \tB. var.list[*].id
      \tC. [ var.list[*].id ]
      \tD. [ for o in var.list : o.id ] """;
    String q38Explanation = " Reference: https://developer.hashicorp.com/terraform/language/values/variables#list ";
    questions.add(new Question(Constants.MULTI_ANSWER, q38, q38Options, "BD", q38Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q39 = "Which argument(s) is (are) required when declaring a Terraform variable?";
    String q39Options = """
      \tA. Type
      \tB. Default
      \tC. Description
      \tD. All of the above
      \tE. None of the above """;
    String q39Explanation = " Reference:  https://www.terraform.io/docs/language/values/variables ";
    questions.add(new Question(Constants.MULTI_CHOICE, q39, q39Options, "E", q39Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q40 = """
      When using a module block to reference a module stored on the public Terraform Module Registry such as:
        module \"consule\" {
          source = \"hashicorp/consul/aws\"
        }
      How do you specify version 1.0.0?""";
    String q40Options = """
      \tA. Modules stored on the public Terraform Module Registry do not support versioning
      \tB. Append ?ref=v1.0.0 argument to the source path
      \tC. Add version = \"1.0.0\" attribute to module block
      \tD. Nothing, modules stored on the public Terraform Module Registry always default to version 1.0.0 """;
    String q40Explanation = " Reference: https://www.terraform.io/docs/language/modules/sources ";
    questions.add(new Question(Constants.MULTI_CHOICE, q40, q40Options, "C", q40Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q41 = "What features does the hosted service Terraform Cloud provide? [Choose Two]";
    String q41Options = """
      \tA. Automated infrastructure deployment visualization
      \tB. Automatic backups
      \tC. Remote state storage
      \tD. A web-based user interface (UI) """;
    String q41Explanation = """
      Reference: https://www.terraform.io/docs/enterprise/admin/automated-recovery 
      Reference: https://www.terraform.io/docs/language/state/remote """;
    questions.add(new Question(Constants.MULTI_ANSWER, q41, q41Options, "CD", q41Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q42 = "Where does the Terraform local backend store its state?";
    String q42Options = """
      \tA. In the /tmp directory
      \tB. In the terraform file
      \tC. In the terraform.tfstate file
      \tD. In the user's terraform.state file """;
    String q42Explanation = """
      Reference: https://www.terraform.io/docs/language/settings/backends/local """;
    questions.add(new Question(Constants.MULTI_CHOICE, q42, q42Options, "C", q42Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q43 = "Which option cannot be used to keep secrets out of Terraform configuration files?";
    String q43Options = """
      \tA. A Terraform provider
      \tB. Environment variables
      \tC. A -var flag
      \tD. Secure string """;
    String q43Explanation = """
      Reference: https://www.terraform.io/use-cases/inject-secrets-into-terraform """;
    questions.add(new Question(Constants.MULTI_CHOICE, q43, q43Options, "D", q43Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q44 = "What is one disadvantage of using dynamic blocks in Terraform?";
    String q44Options = """
      \tA. They cannot be used to loop through a list of values
      \tB. Dynamic blocks can construct repeatable nested blocks
      \tC. They make configuration harder to read and understand
      \tD. Terraform will run more slowly """;
    String q44Explanation = """
      Reference: https://developer.hashicorp.com/terraform/language/expressions/dynamic-blocks """;
    questions.add(new Question(Constants.MULTI_CHOICE, q44, q44Options, "C", q44Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q45 = "Only the user that generated a plan may apply it.";
    String q45Options = "\tT. True\n\tF. False";
    String q45Explanation = """
      Reference: https://developer.hashicorp.com/terraform/cli/commands/plan """;
    questions.add(new Question(Constants.TRUE_FALSE, q45, q45Options, "F", q45Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q46 = """
      You need to specify a dependency manually.
      What resource meta-parameter can you use to make sure Terraform respects the dependency? [fill in the blank]
    """;
    String q46Options = " ";
    String q46Explanation = """
      Reference: https://developer.hashicorp.com/terraform/language/meta-arguments/depends_on """;
    questions.add(new Question(Constants.FILL_BLANK, q46, q46Options, "depends_on", q46Explanation));
// ----------------------------------------------------------------------------------------------------------------------
  }
}
